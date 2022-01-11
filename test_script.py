from subprocess import call,Popen
import os
directory_context_valid = "./src/test/deca/context/valid/provided/"
directory_context_invalid = "./src/test/deca/context/invalid/provided/"
directory_syntaxe_valid = "./src/test/deca/syntax/valid/provided/"
directory_syntaxe_invalid = "./src/test/deca/syntax/invalid/provided/"
for filename in os.listdir(directory_context_invalid):
    if filename == "compare":
        continue
    print("testing", filename, "qui est contextuellement invalide", sep = ' ',end = '\n')
    filename_racine = filename.split('.')[0]
    with open(directory_context_invalid+'compare/'+filename_racine+".lis", 'w') as g:
        process2 = Popen(["test_context",directory_context_invalid+filename], stderr=g, stdout=g)
for filename in os.listdir(directory_context_valid):
    if filename == "compare":
        continue
    print("testing", filename, "qui est contextuellement valide", sep = ' ',end = '\n')
    filename_racine = filename.split('.')[0]
    with open(directory_context_valid+'compare/'+filename_racine+".lis", 'w') as f:
        process = Popen(["test_context",directory_context_valid+filename], stdout=f)

#for filename in os.listdir(directory_syntaxe_invalid):
#    print("testing", filename, "qui est synatxiquement invalide", sep = ' ',end = '\n')
#    call(["test_synt",directory_syntaxe_invalid+filename])
#for filename in os.listdir(directory_syntaxe_valid):
#    print("testing", filename, "qui est synatxiquement valide", sep = ' ',end = '\n')
#    call(["test_synt",directory_syntaxe_valid+filename])
