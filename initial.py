

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

def initial():              return OneOrMore([nclasses,enumeration,database_config]), EOF
def nclasses():             return OneOrMore(nclass)
def nclass():               return CLASS, class_name,Optional(":", class_name), ZeroOrMore(attributes)
def attributes():           return "[", OneOrMore(attribute), "]"
def attribute():            return attribute_key, "=", attribute_value 
def class_name():           return _(r"[a-zA-Z_]([a-zA-Z_]|[0-9])*")
def attribute_value():      return _(r"([a-zA-Z_]|[0-9])*")
def enumeration_value():    return _(r"([a-zA-Z_]|[0-9])*")
def attribute_key():        return [NAME, TYPE, UNIQUE, REQUIRED, MIN, MAX, MANY_TO_ONE, ENUM]
def enumeration():          return ENUMERATION, enumeration_value, ":", OneOrMore(enumeration_element)
def enumeration_element():  return enumeration_value, ";"
def database_config():      return DATABASE, database_value, ":", DRIVER, "=", database_value, USERNAME, "=", database_value, PASSWORD, "=", database_value, URL, "=", url_value, ZeroOrMore(database_table)  
def database_value():       return _(r"([a-zA-Z_.]|[0-9])*")
def url_value():            return _(r"(ftp|file|jdbc:[a-z]+[0-9]*)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]*")
def database_table():       return TABLE, class_name

class Initial(SemanticAction):
  
    def first_pass(self, parser, node, children):
          print "initial!!!!!!"
          env = Environment(loader=FileSystemLoader('templates'))

          
          if not os.path.exists("WebApp/web"):
            os.makedirs("WebApp/web")
          if not os.path.exists("WebApp/src/dao/generic"):
            os.makedirs("WebApp/src/dao/generic")

          if not os.path.exists("WebApp/src/META-INF"):
            os.makedirs("WebApp/src/META-INF")

          if not os.path.exists("WebApp/src/util"):
            os.makedirs("WebApp/src/util")
            
          tmpl = env.get_template('abstract_hibernate_dao.txt')
          filename = "WebApp/src/dao/generic/AbstractHibernateDao.java"
          target = open(filename, 'w+')
          target.write(tmpl.render())
          target.close()

          tmpl = env.get_template('generic_dao.txt')
          filename = "WebApp/src/dao/generic/IGenericDao.java"
          target = open(filename, 'w+')
          target.write(tmpl.render())
          target.close()

          tmpl = env.get_template('error.txt')
          filename = "WebApp/web/error.jsp"
          target = open(filename, 'w+')
          target.write(tmpl.render())
          target.close()

          tmpl = env.get_template('404.txt')
          filename = "WebApp/web/404.jsp"
          target = open(filename, 'w+')
          target.write(tmpl.render())
          target.close()

          tmpl = env.get_template('application.txt')
          filename = "WebApp/src/META-INF/application.xml"
          target = open(filename, 'w+')
          target.write(tmpl.render())
          target.close()

          tmpl = env.get_template('hibernate_util.txt')
          filename = "WebApp/src/util/HibernateUtil.java"
          target = open(filename, 'w+')
          target.write(tmpl.render())
          target.close()

          tmpl = env.get_template('hibernate_listener.txt')
          filename = "WebApp/src/util/HibernateListener.java"
          target = open(filename, 'w+')
          target.write(tmpl.render())
          target.close()

          tmpl = env.get_template('classpath.txt')
          filename = "WebApp/.classpath"
          target = open(filename, 'w+')
          target.write(tmpl.render())
          target.close()

          tmpl = env.get_template('project.txt')
          filename = "WebApp/.project"
          target = open(filename, 'w+')
          target.write(tmpl.render())
          target.close()

          tmpl = env.get_template('build_properties.txt')
          filename = "WebApp/build.properties"
          target = open(filename, 'w+')
          target.write(tmpl.render())
          target.close()

          tmpl = env.get_template('jndi_properties.txt')
          filename = "WebApp/src/jndi.properties"
          target = open(filename, 'w+')
          target.write(tmpl.render())
          target.close()

          tmpl = env.get_template('build.txt')
          filename = "WebApp/build.xml"
          target = open(filename, 'w+')
          target.write(tmpl.render())
          target.close()

          
class Database_config(SemanticAction):
  
    def first_pass(self, parser, node, children):
          print "database_config!!!!!!"
          print str(node[5]) +" "+ str(node[8])+" "+str(node[11])+" "+str(node[14])
          env = Environment(loader=FileSystemLoader('templates'))
          tmpl =  env.get_template('persistence.txt')
          if not os.path.exists("WebApp/src/META-INF"):
            os.makedirs("WebApp/src/META-INF")
          filename = "WebApp/src/META-INF/persistence.xml"
          target = open(filename, 'w+')
          target.write(tmpl.render( name = str(node[1]), driver = str(node[5]), username = str(node[8]), password = str(node[11]),url =str(node[14]), database_tables = children  ))
          target.close()
          tmpl =  env.get_template('hibernate.cfg.txt')
          filename = "WebApp/src/hibernate.cfg.xml"
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
          if not os.path.exists("WebApp/src/enumeration"):
            os.makedirs("WebApp/src/enumeration")
          filename = "WebApp/src/enumeration/"+str(enumeration_name)+".java"
          target = open(filename, 'w+')
          target.write(tmpl.render( enumeration_name = enumeration_name, enumeration_values = children  ))
          target.close()
class NClasses(SemanticAction):
  
    def first_pass(self, parser, node, children):
          print "NClasses!!!!!!"
          parentForeignKey = {}
          parrentAttribute ={}
          allClasses = []

          
          for listClass in children:
              parentForeignKey[listClass[0]] = []
              parrentAttribute[listClass[0]] = []
              allClasses.append(listClass[0])
              
          for listClass in children: # class
              if listClass[1]:       # if specific class has extended some other class             
                  for listClassParent in children: # go to other classes 
                      if listClass[2] == listClassParent[0]: # if this is a parent class
                          for dictonary in listClassParent[3]: # go to attributes of class
                               parrentAttribute[listClass[0]].append(dictonary)
                               if dictonary.get("many_to_one") == 'true':
                                   parentForeignKey[listClass[0]].append(dictonary['type'])
                                   print str(parentForeignKey)
                                   
          env = Environment(loader=FileSystemLoader('templates'))
          tmpl_prepare_add = env.get_template('controller_prepare_add.txt')
          tmpl_add = env.get_template('controller_add.txt')
          tmpl_update = env.get_template('controller_update.txt')
          tmpl_search = env.get_template('controller_search.txt')
          tmp_web_show = env.get_template('web_show.txt')
          tmp_web_add = env.get_template('web_add.txt')
          tmp_web_update = env.get_template('web_update.txt')
          tmp_web_search = env.get_template('web_search.txt')
          tmp_web_home = env.get_template('home.txt')
          tmp_web_xml = env.get_template('web_xml.txt')
          if not os.path.exists("WebApp/src/controller/prepareAdd"):
            os.makedirs("WebApp/src/controller/prepareAdd")
          if not os.path.exists("WebApp/src/controller/add"):
            os.makedirs("WebApp/src/controller/add")
          if not os.path.exists("WebApp/src/controller/update"):
            os.makedirs("WebApp/src/controller/update")
          if not os.path.exists("WebApp/src/controller/search"):
            os.makedirs("WebApp/src/controller/search")
          if not os.path.exists("WebApp/web/WEB-INF"):
            os.makedirs("WebApp/web/WEB-INF")
 
          filename = "WebApp/web/home.jsp"
          target = open(filename, 'w+')
          target.write(tmp_web_home.render( classes = allClasses ))
          target.close()

          filename = "WebApp/web/WEB-INF/web.xml"
          target = open(filename, 'w+')
          target.write(tmp_web_xml.render( classes = allClasses ))
          target.close()
          
          for listClass in children:  
                filename = "WebApp/src/controller/prepareAdd/"+listClass[0]+"ControllerPrepareAdd.java"
                target = open(filename, 'w+')
                target.write(tmpl_prepare_add.render( name = listClass[0], attributes = listClass[3], foreignKeysParent = parentForeignKey[listClass[0]] ))
                target.close()
                filename = "WebApp/src/controller/add/"+listClass[0]+"ControllerAdd.java"
                target = open(filename, 'w+')
                target.write(tmpl_add.render( name = listClass[0], attributes = listClass[3], attributes_parent = parrentAttribute[listClass[0]],foreignKeysParent = parentForeignKey[listClass[0]]))
                target.close()
                filename = "WebApp/src/controller/update/"+listClass[0]+"UpdateController.java"
                target = open(filename, 'w+')
                target.write(tmpl_update.render( name = listClass[0], attributes = listClass[3], attributes_parent = parrentAttribute[listClass[0]],foreignKeysParent = parentForeignKey[listClass[0]]))
                target.close()
                filename = "WebApp/src/controller/search/"+listClass[0]+"SearchController.java"
                target = open(filename, 'w+')
                target.write(tmpl_search.render( name = listClass[0], attributes = listClass[3], attributes_parent = parrentAttribute[listClass[0]]))
                target.close()
                filename = "WebApp/web/"+listClass[0]+"Show.jsp"
                target = open(filename, 'w+')
                target.write(tmp_web_show.render( name = listClass[0], attributes = listClass[3], attributes_parent = parrentAttribute[listClass[0]]))
                target.close()
                filename = "WebApp/web/"+listClass[0]+"Add.jsp"
                target = open(filename, 'w+')
                target.write(tmp_web_add.render( name = listClass[0], attributes = listClass[3], attributes_parent = parrentAttribute[listClass[0]]))
                target.close()
                filename = "WebApp/web/"+listClass[0]+"Update.jsp"
                target = open(filename, 'w+')
                target.write(tmp_web_update.render( name = listClass[0], attributes = listClass[3], attributes_parent = parrentAttribute[listClass[0]]))
                target.close()
                filename = "WebApp/web/"+listClass[0]+"Search.jsp"
                target = open(filename, 'w+')
                target.write(tmp_web_search.render( name = listClass[0], attributes = listClass[3], attributes_parent = parrentAttribute[listClass[0]]))
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
          if not os.path.exists("WebApp"):
            os.makedirs("WebApp")
          if not os.path.exists("WebApp/src/model"):
            os.makedirs("WebApp/src/model")
          if not os.path.exists("WebApp/src/dao"):
            os.makedirs("WebApp/src/dao") 
          filename = "WebApp/src/model/"+str(className)+".java"
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
          
          env = Environment(loader=FileSystemLoader('templates'))
          tmpl = env.get_template('controller_show.txt')
          if not os.path.exists("WebApp/src/controller/show"):
            os.makedirs("WebApp/src/controller/show")
          if not os.path.exists("WebApp/src/controller/delete"):
            os.makedirs("WebApp/src/controller/delete")
          if not os.path.exists("WebApp/src/controller/prepareUpdate"):
            os.makedirs("WebApp/src/controller/prepareUpdate")
            
          filename = "WebApp/src/controller/show/"+str(className)+"ControllerShow.java"
          target = open(filename, 'w+')
          target.write(tmpl.render( name = str(className)))
          target.close()
          
          tmpl = env.get_template('controller_delete.txt')
          filename = "WebApp/src/controller/delete/"+str(className)+"DeleteController.java"
          target = open(filename, 'w+')
          target.write(tmpl.render( name = str(className)))
          target.close()

          tmpl = env.get_template('controller_prepare_update.txt')
          filename = "WebApp/src/controller/prepareUpdate/"+str(className)+"PrepareUpdateController.java"
          target = open(filename, 'w+')
          target.write(tmpl.render( name = str(className),attributes = children))
          target.close()

          tmpl = env.get_template('dao.txt')
          filename = "WebApp/src/dao/I"+str(className)+"Dao.java"
          target = open(filename, 'w+')
          target.write(tmpl.render( name = str(className)))
          target.close()

          tmpl = env.get_template('hibernate_dao.txt')
          filename = "WebApp/src/dao/"+str(className)+"HibernateDao.java"
          target = open(filename, 'w+')
          target.write(tmpl.render( name = str(className)))
          target.close()
          
          return [str(className),superClass,parentClass,children]

# Connecting rules with semantic actions    
initial.sem =  Initial()
nclasses.sem = NClasses()
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

