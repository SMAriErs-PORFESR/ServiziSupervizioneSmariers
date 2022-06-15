#!/usr/bin/python
import socket 
import time
import os
import sqlite3
import sys
from collections import OrderedDict

if len(sys.argv)<2:
	print('mancadb')
	exit(0)
argom  = sys.argv[1]
con = sqlite3.connect(argom)

cur = con.cursor()
previusappmod = 0
i =  0
map = OrderedDict()

for row in cur.execute('SELECT ADDRPER, DESCRIZIONE FROM CONF_MODULE ORDER BY ADDRPER'):
		currentappmod = hex(row[0])
		if not currentappmod in map:
			map[row[0]] = row[1]
		
print(map.keys())

data = "data/"+argom[:len(argom)-4]+"/"
print(data)
os.makedirs(os.path.dirname(data), exist_ok=True)

name = argom[:len(argom)-4]
print(name)
with open(data+name.zfill(2)+'.nomiperiferiche.txt', 'w') as f:
	for row in map:
		line  = str(hex(int(row)))[2:]+"="+str(map[row])
		f.write(str(line)+'\r\n')
		
	
##TIPI EVENTI
map =  OrderedDict()
print('##TIPI EVENTI##')
for row in cur.execute('SELECT TYPEEVT, DESCR FROM TIPI_EVENTO ORDER BY TYPEEVT'):
		currentappmod = hex(row[0])
		if not currentappmod in map:
			map[row[0]] = row[1]
		
print(map.keys())

data = "data/"+argom[:len(argom)-4]+"/"
print(data)
os.makedirs(os.path.dirname(data), exist_ok=True)

name = argom[:len(argom)-4]
print(name)
with open(data+name.zfill(2)+'.tipievento.txt', 'w') as f:
	for row in map:
		line  = str((int(row)))+"="+str(map[row])
		f.write(str(line)+'\r\n')
		
