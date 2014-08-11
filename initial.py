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
# PEG syntax rules

def initial():          return OneOrMore(nclass), EOF
def nclass():           return CLASS, class_name,Optional(":", class_name), ZeroOrMore(attribute)
def attribute():        return attribute_name, ":", attribute_name
def class_name():       return _(r"[a-zA-Z_]([a-zA-Z_]|[0-9])*")
def attribute_name():   return _(r"[a-zA-Z_]([a-zA-Z_]|[0-9])*")


class Initial(SemanticAction):
  
    def first_pass(self, parser, node, children):
          print "initial!!!!!!"
          
	
class Class_name(SemanticAction):
  
    def first_pass(self, parser, node, children):
          print "class_name!!!!!"
          			  
	
class NClass(SemanticAction):
    """
    Create POJO class
    """
    def first_pass(self, parser, node, children):
          print "usao sam!!!!!!!!!"
          if parser.debug:
            print node[1]
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
                  
            
          
          target.write(tmpl.render( nameClass = str(className),superClass = superClass ,parentClass = parentClass))
          target.close()
          return 0

# Connecting rules with semantic actions    
initial.sem =  Initial()     
class_name.sem = Class_name()
nclass.sem = NClass()
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

