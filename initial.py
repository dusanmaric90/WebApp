

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
def MIN():            return "min_length"
def MAX():            return "max_length"
def MANY_TO_ONE():    return "many_to_one"
def ONE_TO_MANY():    return "one_to_many"
def ENUM():           return "enum"
def ENUMERATION():    return "enumeration"
def DATABASE():       return "database"
def DRIVER():         return "driver"
def USERNAME():       return "username"
def PASSWORD():       return "password"
def URL():            return "url"
def TABLE():          return "table"
def SHOW():           return "show"
def LABEL():          return "label"




# PEG syntax rules

def initial():               return OneOrMore([nclasses,enumeration]),database_config, EOF
def nclasses():              return OneOrMore(nclass)
def nclass():                return  Optional(ABSTRACT),CLASS, class_name,Optional(":", class_name), ZeroOrMore(attributes)
def attributes():            return "[", OneOrMore(attribute), Optional(attribute_label),"]"
def attribute():             return attribute_key, "=", attribute_value
def attribute_label():       return LABEL,"=",r'"', attribute_label_value,r'"'
def attribute_label_value(): return _(r"([a-zA-Z_\s])*")
def class_name():            return _(r"[a-zA-Z_]([a-zA-Z_]|[0-9])*")
def attribute_value():       return _(r"([a-zA-Z_]|[0-9])*")
def enumeration_value():     return _(r"([a-zA-Z_ ]|[0-9])*")
def attribute_key():         return [NAME, TYPE, UNIQUE, REQUIRED, MIN, MAX, MANY_TO_ONE, ENUM, ONE_TO_MANY, SHOW]
def enumeration():           return ENUMERATION, enumeration_value, ":", OneOrMore(enumeration_element)
def enumeration_element():   return enumeration_value, [",",";"]
def database_config():       return DATABASE, database_value, ":", DRIVER, "=", database_value, USERNAME, "=", database_value, PASSWORD, "=", database_value, URL, "=", url_value, ZeroOrMore(database_table)  
def database_value():        return _(r"([a-zA-Z_.]|[0-9])*")
def url_value():             return _(r"(ftp|file|jdbc:[a-z]+[0-9]*)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]*")
def database_table():        return TABLE, class_name


def generate_text_file_project(tmpl, filename):
    target = open(filename, 'w+')
    target.write(tmpl.render())
    target.close()
    
def generate_text_file_database_persistence(tmpl, filename, name, driver, username, password, url, database_tables):
    target = open(filename, 'w+')
    target.write(tmpl.render( name = name, driver = driver, username = username, password = password,url =url, database_tables = database_tables  ))
    target.close()
     
def generate_text_file_database_hibernate(tmpl, filename, driver, username, password, url, database_tables ):
    target = open(filename, 'w+')
    target.write(tmpl.render( driver = driver, username = username, password = password,url =url, database_tables = database_tables  ))
    target.close()

def generate_text_file_enumeration(tmpl, filename, enumeration_name, enumeration_values):
    target = open(filename, 'w+')
    target.write(tmpl.render( enumeration_name = enumeration_name, enumeration_values = enumeration_values  ))
    target.close()

def generate_text_file_all_classes(tmpl, filename, classes):
    target = open(filename, 'w+')
    target.write(tmpl.render( classes = classes ))
    target.close()
    
def generate_text_file_class_foreign_key(tmpl, filename, name, attributes, foreignKeysParent):
    target = open(filename, 'w+')
    target.write(tmpl.render( name = name, attributes = attributes, foreignKeysParent = foreignKeysParent ))
    target.close()

def generate_text_file_class_foreign_key_parent(tmpl, filename, name, attributes, attributes_parent, foreignKeysParent):
    target = open(filename, 'w+')
    target.write(tmpl.render( name = name, attributes = attributes, attributes_parent = attributes_parent,foreignKeysParent = foreignKeysParent))
    target.close()

def generate_text_file_class_attributes(tmpl, filename, name, attributes, attributes_parent):
    target = open(filename, 'w+')
    target.write(tmpl.render( name = name, attributes = attributes, attributes_parent = attributes_parent))
    target.close()

def generate_text_file_class_model(tmpl, filename, nameClass, superClass, parentClass, attributes, abstract):
    target = open(filename, 'w+')
    target.write(tmpl.render( nameClass = nameClass,superClass = superClass ,parentClass = parentClass, attributes = attributes, abstract = abstract ))
    target.close()

def generate_text_file_class(tmpl, filename, name):
    target = open(filename, 'w+')
    target.write(tmpl.render( name = name))
    target.close()

def generate_text_file_class_attribute(tmpl, filename, name, attributes):
    target = open(filename, 'w+')
    target.write(tmpl.render( name = name,attributes = attributes))
    target.close()
    
class Initial(SemanticAction):
  
    def first_pass(self, parser, node, children):
          print "initial!!!!!!"
          
          env = Environment(loader=FileSystemLoader('templates'))
          env_web = Environment(loader=FileSystemLoader('templates/web'))
          env_dao = Environment(loader=FileSystemLoader('templates/dao'))
          env_hibernate = Environment(loader=FileSystemLoader('templates/hibernate'))
          env_project = Environment(loader=FileSystemLoader('templates/project'))
          
          if not os.path.exists("WebApp/web"):
            os.makedirs("WebApp/web")
          if not os.path.exists("WebApp/src/dao/generic"):
            os.makedirs("WebApp/src/dao/generic")

          if not os.path.exists("WebApp/src/META-INF"):
            os.makedirs("WebApp/src/META-INF")

          if not os.path.exists("WebApp/src/util"):
            os.makedirs("WebApp/src/util")

          generate_text_file_project(env_dao.get_template('abstract_hibernate_dao.txt'),"WebApp/src/dao/generic/AbstractHibernateDao.java")  
          generate_text_file_project(env_dao.get_template('generic_dao.txt'),"WebApp/src/dao/generic/IGenericDao.java")  
          generate_text_file_project(env_web.get_template('error.txt'),"WebApp/web/error.jsp")
          generate_text_file_project(env_web.get_template('404.txt'),"WebApp/web/404.jsp")
          generate_text_file_project(env_project.get_template('application.txt'),"WebApp/src/META-INF/application.xml")
          generate_text_file_project(env_hibernate.get_template('hibernate_util.txt'),"WebApp/src/util/HibernateUtil.java")
          generate_text_file_project(env_hibernate.get_template('hibernate_listener.txt'),"WebApp/src/util/HibernateListener.java")
          generate_text_file_project(env_project.get_template('classpath.txt'),"WebApp/.classpath")
          generate_text_file_project(env_project.get_template('project.txt'),"WebApp/.project")
          generate_text_file_project(env_project.get_template('build_properties.txt'),"WebApp/build.properties")
          generate_text_file_project(env_project.get_template('jndi_properties.txt'),"WebApp/src/jndi.properties")
          generate_text_file_project(env_project.get_template('build.txt'),"WebApp/build.xml")
          generate_text_file_project(env_web.get_template('css.txt'),"WebApp/web/style.css")
          generate_text_file_project(env_web.get_template('home.txt'),"WebApp/web/home.jsp")

          
class Database_config(SemanticAction):
  
    def first_pass(self, parser, node, children):
          print "database_config!!!!!!"
          
          env = Environment(loader=FileSystemLoader('templates/hibernate'))
          
          if not os.path.exists("WebApp/src/META-INF"):
            os.makedirs("WebApp/src/META-INF")

          generate_text_file_database_persistence(env.get_template('persistence.txt'),"WebApp/src/META-INF/persistence.xml", str(node[1]), str(node[5]),str(node[8]),str(node[11]),str(node[14]),children)
          generate_text_file_database_hibernate(env.get_template('hibernate.cfg.txt'), "WebApp/src/hibernate.cfg.xml", str(node[5]), str(node[8]), str(node[11]), str(node[14]), children)
       
class Attribute_label(SemanticAction):
  
    def first_pass(self, parser, node, children):
          print "attribute_label!!!!!!"
          retVal = [ str(node[0]), str(node[3])]  
          return retVal
         
class Attribute_label_value(SemanticAction):
  
    def first_pass(self, parser, node, children):
          print "attribute_label_value!!!!!!"
          
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
          
          env = Environment(loader=FileSystemLoader('templates/enumeration'))
        
          if not os.path.exists("WebApp/src/model"):
            os.makedirs("WebApp/src/model")
            
          generate_text_file_enumeration(env.get_template('enumeration.txt'), "WebApp/src/model/"+str(node[1])+".java", str(node[1]), children)
        
class NClasses(SemanticAction):
  
    def first_pass(self, parser, node, children):
          print "NClasses!!!!!!"
          
          parentForeignKey = {}
          parrentAttribute ={}
          allClasses = []
          allClassesNotAbstract = []
        
          
          for listClass in children:
              parentForeignKey[listClass[0]] = []
              parrentAttribute[listClass[0]] = []
              allClasses.append(listClass[0])
              if listClass[4] == False:
                 allClassesNotAbstract.append(listClass[0]) 
              
              
              
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
          env_controller = Environment(loader=FileSystemLoader('templates/controller'))
          env_web = Environment(loader=FileSystemLoader('templates/web'))
         
          if not os.path.exists("WebApp/src/controller/prepareAdd"):
            os.makedirs("WebApp/src/controller/prepareAdd")
          if not os.path.exists("WebApp/src/controller/prepareSearch"):
            os.makedirs("WebApp/src/controller/prepareSearch")  
          if not os.path.exists("WebApp/src/controller/add"):
            os.makedirs("WebApp/src/controller/add")
          if not os.path.exists("WebApp/src/controller/update"):
            os.makedirs("WebApp/src/controller/update")
          if not os.path.exists("WebApp/src/controller/search"):
            os.makedirs("WebApp/src/controller/search")
          if not os.path.exists("WebApp/web/WEB-INF"):
            os.makedirs("WebApp/web/WEB-INF")
 
          
          generate_text_file_all_classes(env_web.get_template('web_xml.txt'), "WebApp/web/WEB-INF/web.xml", allClassesNotAbstract)
          generate_text_file_all_classes(env_web.get_template('menu.txt'), "WebApp/web/menu.jsp", allClassesNotAbstract)

          
          for listClass in children:
                if listClass[4] == False:
                    generate_text_file_class_foreign_key(env_controller.get_template('controller_prepare_add.txt'), "WebApp/src/controller/prepareAdd/"+listClass[0]+"ControllerPrepareAdd.java", listClass[0], listClass[3], parentForeignKey[listClass[0]])
                    generate_text_file_class_foreign_key(env_controller.get_template('controller_prepare_search.txt'), "WebApp/src/controller/prepareSearch/"+listClass[0]+"ControllerPrepareSearch.java", listClass[0], listClass[3], parentForeignKey[listClass[0]])
                    generate_text_file_class_foreign_key_parent(env_controller.get_template('controller_add.txt'), "WebApp/src/controller/add/"+listClass[0]+"ControllerAdd.java", listClass[0], listClass[3], parrentAttribute[listClass[0]], parentForeignKey[listClass[0]])
                    generate_text_file_class_foreign_key_parent(env_controller.get_template('controller_update.txt'), "WebApp/src/controller/update/"+listClass[0]+"UpdateController.java", listClass[0], listClass[3], parrentAttribute[listClass[0]], parentForeignKey[listClass[0]])
                    generate_text_file_class_attributes(env_controller.get_template('controller_search.txt'), "WebApp/src/controller/search/"+listClass[0]+"SearchController.java", listClass[0], listClass[3], parrentAttribute[listClass[0]])
                    generate_text_file_class_attributes(env_web.get_template('web_show.txt'), "WebApp/web/"+listClass[0]+"Show.jsp", listClass[0], listClass[3], parrentAttribute[listClass[0]])
                    generate_text_file_class_attributes(env_web.get_template('web_add.txt'), "WebApp/web/"+listClass[0]+"Add.jsp", listClass[0], listClass[3], parrentAttribute[listClass[0]])
                    generate_text_file_class_attributes(env_web.get_template('web_update.txt'), "WebApp/web/"+listClass[0]+"Update.jsp", listClass[0], listClass[3], parrentAttribute[listClass[0]])
                    generate_text_file_class_attributes(env_web.get_template('web_search.txt'), "WebApp/web/"+listClass[0]+"Search.jsp", listClass[0], listClass[3], parrentAttribute[listClass[0]])
                   

               
          
class NClass(SemanticAction):

    def first_pass(self, parser, node, children):
          print "NClass!!!!!!!!!"
          abstract = False
          if node[0] == "abstract":
            node.pop(0)
            children.pop(0)
            abstract = True
           
      
          env_model = Environment(loader=FileSystemLoader('templates/model'))
          env_dao = Environment(loader=FileSystemLoader('templates/dao'))
          env_controller = Environment(loader=FileSystemLoader('templates/controller'))
          
          if not os.path.exists("WebApp/src/model"):
            os.makedirs("WebApp/src/model")
          if not os.path.exists("WebApp/src/dao"):
            os.makedirs("WebApp/src/dao") 
          if not os.path.exists("WebApp/src/controller/show"):
            os.makedirs("WebApp/src/controller/show")
          if not os.path.exists("WebApp/src/controller/delete"):
            os.makedirs("WebApp/src/controller/delete")
          if not os.path.exists("WebApp/src/controller/prepareUpdate"):
            os.makedirs("WebApp/src/controller/prepareUpdate")
            
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
              
          
          generate_text_file_class_model(env_model.get_template('model.txt'), "WebApp/src/model/"+str(node[1])+".java", str(node[1]), superClass, parentClass, children, abstract) 
        
          if abstract == False :
              generate_text_file_class(env_controller.get_template('controller_show.txt'),"WebApp/src/controller/show/"+str(node[1])+"ControllerShow.java",str(node[1]))
              generate_text_file_class(env_controller.get_template('controller_delete.txt'),"WebApp/src/controller/delete/"+str(node[1])+"DeleteController.java",str(node[1]))
              generate_text_file_class(env_dao.get_template('dao.txt'),"WebApp/src/dao/I"+str(node[1])+"Dao.java",str(node[1]))
              generate_text_file_class(env_dao.get_template('hibernate_dao.txt'),"WebApp/src/dao/"+str(node[1])+"HibernateDao.java",str(node[1]))
              generate_text_file_class_attribute(env_controller.get_template('controller_prepare_update.txt'), "WebApp/src/controller/prepareUpdate/"+str(node[1])+"PrepareUpdateController.java", str(node[1]), children)
            

          return [str(node[1]),superClass,parentClass,children,abstract]

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
attribute_label.sem = Attribute_label()
attribute_label_value.sem = Attribute_label_value()

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
    main(debug=False)

