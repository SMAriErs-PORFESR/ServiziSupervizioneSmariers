#!/bin/bash
echo -----START------ 
for name in *.FSX; do
	echo -----  $name ----------
	echo -----  IO ----------
	python3 ReadSQLiteListIO.py $name
	echo -----  Eveni ----------
	python3 ReadSQLiteEventi.py $name
	echo -----FINE---CILCO------ 
done