#!/usr/bin/env python3
from subprocess import call,Popen
import os
directory_context_valid = "./src/test/deca/context/valid/provided/"
directory_context_invalid = "./src/test/deca/context/invalid/provided/"
directory_syntaxe_valid = "./src/test/deca/syntax/valid/provided/"
directory_syntaxe_invalid = "./src/test/deca/syntax/invalid/provided/"
def verify(file_racine, directory):
    with open(directory+'compare/'+file_racine+"_test_result"+".lis", 'r') as f:
        with open(directory+'compare/'+file_racine+".lis", 'r') as k:
            for line_file_test in f.readlines():
                for line_file_correction in k.readlines():
                    if(line_file_test != line_file_correction):
                        print("TEST FAILED!!!")
                        print("==============================")
                        return
            print("TEST PASSED")
            print("==============================")

for filename in os.listdir(directory_context_invalid):
    if filename == "compare":
        continue
    print("testing", filename, "qui est contextuellement invalide", sep = ' ',end = '\n')
    filename_racine = filename.split('.')[0]
    with open(directory_context_invalid+'compare/'+filename_racine+"_test_result"+".lis", 'w') as g:
        process2 = Popen(["test_context",directory_context_invalid+filename], stderr=g, stdout=g)
    verify(filename_racine, directory_context_invalid)
for filename in os.listdir(directory_context_valid):
    if filename == "compare":
        continue
    print("testing", filename, "qui est contextuellement valide", sep = ' ',end = '\n')
    filename_racine = filename.split('.')[0]
    with open(directory_context_valid+'compare/'+filename_racine+"_test_result"+".lis", 'w') as f:
        process = Popen(["test_context",directory_context_valid+filename], stdout=f)
    verify(filename_racine, directory_context_valid)


#for filename in os.listdir(directory_syntaxe_invalid):
#    print("testing", filename, "qui est synatxiquement invalide", sep = ' ',end = '\n')
#    call(["test_synt",directory_syntaxe_invalid+filename])
#for filename in os.listdir(directory_syntaxe_valid):
#    print("testing", filename, "qui est synatxiquement valide", sep = ' ',end = '\n')
#    call(["test_synt",directory_syntaxe_valid+filename])
