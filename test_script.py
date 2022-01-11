from subprocess import call
import os
directory_context_valid = "./src/test/deca/context/valid/provided/"
directory_context_invalid = "./src/test/deca/context/invalid/provided/"
directory_syntaxe_valid = "./src/test/deca/syntax/valid/provided/"
directory_syntaxe_invalid = "./src/test/deca/syntax/invalid/provided/"
for filename in os.listdir(directory_context_valid):
    print("testing", filename, "qui est contextuellement valide", sep = ' ',end = '\n')
    call(["test_context",directory_context_valid+filename])
for filename in os.listdir(directory_context_invalid):
    print("testing", filename, "qui est contextuellement invalide", sep = ' ',end = '\n')
    call(["test_context",directory_context_invalid+filename])
for filename in os.listdir(directory_syntaxe_invalid):
    print("testing", filename, "qui est synatxiquement invalide", sep = ' ',end = '\n')
    call(["test_synt",directory_syntaxe_invalid+filename])
for filename in os.listdir(directory_syntaxe_valid):
    print("testing", filename, "qui est synatxiquement valide", sep = ' ',end = '\n')
    call(["test_synt",directory_syntaxe_valid+filename])
