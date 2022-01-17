#! /bin/sh

# Auteur : gl46
# Version initiale : 01/01/2022

# Test minimaliste de la vérification contextuelle.
# Le principe et les limitations sont les mêmes que pour basic-synt.sh
cd "$(dirname "$0")"/../../.. || exit 1

PATH=./src/test/script/launchers:"$PATH"
test_codegen () {
    # $1 = premier argument.
    if decac "$1" 2>&1 | \
    	grep -q -e '.'
	then
    	echo "Echec inattendu pour la compilation $1"
    	exit 1
	else
    	echo "Succes attendu de compilation $1"
	fi
}  
test_codegen_decompile () {
    # $1 = premier argument.
    if decac -p "$1" 2>&1 | \
    	grep -q -e "$1:[0-9][0-9]*:"
	then
    	echo "Echec inattendu pour la decompilation $1"
    	exit 1
	else
    	echo "Succes attendu de decompilation $1"
	fi
} 
decac -b 
decac -r 5 src/test/deca/codegen/valid/provided/push_pop.deca
#decac src/test/deca/codegen/valid/provided/push_pop.deca -p
for cas_de_test in src/test/deca/codegen/valid/provided/*.deca
do
    test_codegen "$cas_de_test"
    test_codegen_decompile "$cas_de_test"
done
for cas_de_test_b in src/test/deca/codegen/invalid/*.deca
do
    test_codegen "$cas_de_test_b"
    test_codegen_decompile "$cas_de_test_b"
done
for cas_de_test_c in src/test/deca/codegen/perf/provided/*.deca
do
    test_codegen "$cas_de_test_c"
    test_codegen_decompile "$cas_de_test_c"
done


