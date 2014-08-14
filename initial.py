#######################################################################
# Name: calc.py
# Purpose: Simple expression evaluator example
# Author: Igor R. Dejanovic <igor DOT dejanovic AT gmail DOT com>
# Copyright: (c) 2009-2014 Igor R. Dejanovic <igor DOT dejanovic AT gmail DOT com>
# License: MIT License
#
# This example demonstrates grammar definition using python constructs as
# well as using semantic actions to evaluate simple expression in infix
# notation.
#######################################################################

from arpeggio import Optional, ZeroOrMore, OneOrMore, EOF, SemanticAction,\
    ParserPython
from arpeggio import RegExMatch as _
import os;
from jinja2 import Environment
from jinja2.loaders import FileSystemLoader

# PEG Lexical rules
def CLASS():           return "class"
def ABSTRACT():        return "abstract"

# Attribute Lexical rules
def NAME():           return "name"
def TYPE():           return "type"
def UNIQUE():         return "unique"
def REQUIRED():       return "required"
def MIN():            return "min"
def MAX():            return "max"
def TRANSIENT():      return "transient"
def MANY_TO_ONE():    return "many_to_one"
def ENUM():           return "enum"
def ENUMERATION():    return "enumeration"
def DATABASE():       return "database"
def DRIVER():         return "driver"
def USERNAME():       return "username"
def PASSWORD():       return "password"
def URL():            return "url"
def TABLE():          return "table"




# PEG syntax rules

def initial():              return OneOrMore([nclass,enumeration,database_config]), EOF
def nclass():               return CLASS, class_name,Optional(":", class_name), ZeroOrMore(attributes)
def attributes():           return "[", OneOrMore(attribute), "]"
def attribute():            return attribute_key, "=", attribute_value 
def class_name():           return _(r"[a-zA-Z_]([a-zA-Z_]|[0-9])*")
def attribute_value():      return _(r"([a-zA-Z_]|[0-9])*")
def enumeration_value():    return _(r"([a-zA-Z_]|[0-9])*")
def attribute_key():        return [NAME, TYPE, UNIQUE, REQUIRED, MIN, MAX, TRANSIENT, MANY_TO_ONE, ENUM]
def enumeration():          return ENUMERATION, enumeration_value, ":", OneOrMore(enumeration_element)
def enumeration_element():  return enumeration_value, ";"
def database_config():      return DATABASE, database_value, ":", DRIVER, "=", database_value, USERNAME, "=", database_value, PASSWORD, "=", database_value, URL, "=", url_value, ZeroOrMore(database_table)  
def database_value():       return _(r"([a-zA-Z_.]|[0-9])*")
def url_value():            return _(r"(ftp|file|jdbc:[a-z]+[0-9]*)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]*")
def database_table():       return TABLE, class_name

class Initial(SemanticAction):
  
    def first_pass(self, parser, node, children):
          print "initial!!!!!!"
          
class Database_config(SemanticAction):
  
    def first_pass(self, parser, node, children):
          print "database_config!!!!!!"
          print str(node[5]) +" "+ str(node[8])+" "+str(node[11])+" "+str(node[14])
          env = Environment(loader=FileSystemLoader('templates'))
          tmpl =  env.get_template('persistence.txt')
          if not os.path.exists("META-INF"):
            os.makedirs("META-INF")
          filename = "META-INF/persistence.xml"
          target = open(filename, 'w+')
          target.write(tmpl.render( name = str(node[1]), driver = str(node[5]), username = str(node[8]), password = str(node[11]),url =str(node[14]), database_tables = children  ))
          target.close()
          tmpl =  env.get_template('hibernate.cfg.txt')
          filename = "hibernate.cfg.xml"
          target = open(filename, 'w+')
          target.write(tmpl.render( driver = str(node[5]), username = str(node[8]), password = str(node[11]),url =str(node[14]), database_tables = children  ))
          target.close()
class Database_value(SemanticAction):
  
    def first_pass(self, parser, node, children):
          print "database_value!!!!!!"
        

class Url_value(SemanticAction):
  
    def first_pass(self, parser, node, children):
          print "url_value!!!!!!"
          
class Database_table(SemanticAction):
  
    def first_pass(self, parser, node, children):
          print "database_table!!!!!!"
          return str(node[1]) 

class Enumeration_element(SemanticAction):
  
    def first_pass(self, parser, node, children):
          print "enumeration_element!!!!!!"
          return str(node[0])

class Enumeration_value(SemanticAction):
  
    def first_pass(self, parser, node, children):
          print "enumeration_value!!!!!!"
          
class Class_name(SemanticAction):
  
    def first_pass(self, parser, node, children):
          print "class_name!!!!!"
class Attributes(SemanticAction):
  
    def first_pass(self, parser, node, children):
          print "attributes!!!!!"
          attributes = {}
          for listChildren in children:
              attributes[listChildren[0]]=listChildren[1]
          return attributes
          
class Attribute(SemanticAction):
  
    def first_pass(self, parser, node, children):
          print "attribute!!!!!"
          retVal = [ str(node[0]), str(node[2])]
          return retVal
          
         
class Attribute_key(SemanticAction):
  
    def first_pass(self, parser, node, children):
          print "attribute_key!!!!!"
class Attribute_value(SemanticAction):
  
    def first_pass(self, parser, node, children):
          print "attribute_value!!!!!"
          
class Enumeration(SemanticAction):
  
    def first_pass(self, parser, node, children):
          print "enumeration!!!!!!"
           
          enumeration_name = node[1]
          
          env = Environment(loader=FileSystemLoader('templates'))
          tmpl =  env.get_template('enumeration.txt')
          if not os.path.exists("enumeration"):
            os.makedirs("enumeration")
          filename = "enumeration/"+str(enumeration_name)+".java"
          target = open(filename, 'w+')
          target.write(tmpl.render( enumeration_name = enumeration_name, enumeration_values = children  ))
          target.close()
	    
class NClass(SemanticAction):
    """
    Create POJO class
    """
    def first_pass(self, parser, node, children):
          print "usao sam!!!!!!!!!"
          if parser.debug:
            print node[1]
          for i in children:
            for key, value in i.iteritems():
                print "Key = "+key +" Value = "+value
          className = node[1]
          env = Environment(loader=FileSystemLoader('templates'))
          tmpl = env.get_template('model.txt')
          if not os.path.exists("model"):
            os.makedirs("model")
          filename = "model/"+str(className)+".java"
          print filename
          target = open(filename, 'w+')
          length = len(node)
          if length > 3 :
              if node[2] == ":" :
                 parentClass = node[3]
                 superClass = True
              else: 
                  superClass = False
                  parentClass = "" 
          else: 
              superClass = False
              parentClass = ""
                  
            
          
          target.write(tmpl.render( nameClass = str(className),superClass = superClass ,parentClass = parentClass, attributes = children ))
          target.close()
          return 0

# Connecting rules with semantic actions    
initial.sem =  Initial()     
class_name.sem = Class_name()
nclass.sem = NClass()
attributes.sem = Attributes()
attribute.sem = Attribute()
attribute_key.sem = Attribute_key()
attribute_value.sem = Attribute_value()
enumeration_value.sem = Enumeration_value()
enumeration.sem = Enumeration()
enumeration_element.sem = Enumeration_element()
database_config.sem = Database_config()
database_value.sem = Database_value()
url_value.sem = Url_value()
database_table.sem = Database_table()

def main(debug=False):
    # First we will make a parser - an instance of the calc parser model.
    # Parser model is given in the form of python constructs therefore we
    # are using ParserPython class.
    parser = ParserPython(initial, debug=debug)
    file_input = open("input.txt", 'r')
   
    input_expr = file_input.read()

    # We create a parse tree out of textual input_expr
    parse_tree = parser.parse(input_expr)

    result = parser.getASG()

    

if __name__ == "__main__":
    # In debug mode dot (graphviz) files for parser model
    # and parse tree will be created for visualization.
    # Checkout current folder for .dot files.
    main(debug=True)

