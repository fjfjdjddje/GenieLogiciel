#!/usr/bin/env python3
from subprocess import call,Popen, PIPE
import os
directory_context_invalid = "./src/test/deca/context/invalid/provided/"
with open("storage.txt", 'w') as g:
    for filename in os.listdir(directory_context_invalid):
        print("testing", filename, "qui est contextuellement invalide", sep = ' ',end = '\n')
        g.write("if test_context "+ filename + " 2>&1 | \\\n")
        process2 = Popen(["test_context",directory_context_invalid+filename], stderr=PIPE)
        g.write("grep -q -e " +"\""+process2.stderr.readline().decode("utf-8").split("/")[-1]+"\""+"\n")
        g.write("then\n")
        g.write("    echo \"Echec attendu pour test_context\"\n")
        g.write("else\n")
        g.write("    echo \"Succes inattendu de test_context\"\n")
        g.write("    exit 1\n")
        g.write("fi\n")
#for filename in os.listdir(directory_context_valid):
#    if filename == "compare":
#        continue
#    print("testing", filename, "qui est contextuellement valide", sep = ' ',end = '\n')
#    filename_racine = filename.split('.')[0]
#    with open(directory_context_valid+'compare/'+filename_racine+".lis", 'w') as f:
#        process = Popen(["test_context",directory_context_valid+filename], stdout=f)

#for filename in os.listdir(directory_syntaxe_invalid):
#    print("testing", filename, "qui est synatxiquement invalide", sep = ' ',end = '\n')
#    call(["test_synt",directory_syntaxe_invalid+filename])
#for filename in os.listdir(directory_syntaxe_valid):
#    print("testing", filename, "qui est synatxiquement valide", sep = ' ',end = '\n')
#    call(["test_synt",directory_syntaxe_valid+filename])
