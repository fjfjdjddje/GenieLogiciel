#! /bin/sh

# Auteur : gl46
# Version initiale : 01/01/2022

# Test minimaliste de la vérification contextuelle.
# Le principe et les limitations sont les mêmes que pour basic-synt.sh
cd "$(dirname "$0")"/../../.. || exit 1

PATH=./src/test/script/launchers:"$PATH"
#fr cas_de_test in src/test/deca/context/invalid/provided/*.deca
#o
#   test_context $cas_de_test 2>>test.txt
#   echo " \n ">>test.txt
#one
x = "ls"
echo $x
