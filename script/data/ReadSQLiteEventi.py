#!/usr/bin/python
import socket 
import time
import os
import sqlite3
import sys

if len(sys.argv)<2:
	print('mancadb')
	exit(0)
argom  = sys.argv[1]
con = sqlite3.connect(argom)

cur = con.cursor()
previusappmod = 0
i =  0
map = {}
'''listAPPMOD = []
for row in cur.execute('SELECT * FROM LIST_EVENTS ORDER BY APPMOD'):
		currentappmod = hex(row[1])
		if not currentappmod in listAPPMOD:
			listAPPMOD.append(currentappmod)
		
print(listAPPMOD)'''

def scrivi(data,name,des,p):
	with open(data+name.zfill(2)+'.'+des+'.txt', 'w') as f:
		for row in p:#Codice=descizione,tipoevento,gruppo
			line  = str(row[2])+"="+str(row[6])+","+str(row[5])+","+str(row[3])+""
			f.write(str(line)+'\r\n')
		f.write('\r\n')

rename = {}
for row in cur.execute('SELECT * FROM CONF_MODULE ORDER BY TYPEAPP'):
		currenttypeapp = hex(abs(row[20]))
		currenttdper = hex(abs(row[6]))
		print(currenttypeapp,currenttdper)
		if not  currenttypeapp in rename:
			list = []
			list.append(currenttdper)
			rename[currenttypeapp]= list
		else:
			z = rename[currenttypeapp]
			z.append(currenttdper)

data = "data/"+argom[:len(argom)-4]+"/"
os.makedirs(os.path.dirname(data), exist_ok=True)
for row in cur.execute('SELECT * FROM LIST_EVENTS ORDER BY APPMOD'):
		currentappmod = hex(row[1])
		if not currentappmod in map:
			map[currentappmod] = [row]
		else:
			list = map[currentappmod]
			list.append(row)
			
for element in map:
	name = element[2:]
	with open(data+name.zfill(2)+'.eventi.txt', 'w') as f:
		for row in map[element]:#Codice=descizione,tipoevento,gruppo
			line  = str(row[2])+"="+str(row[6])+","+str(row[5])+","+str(row[3])+""
			f.write(str(line)+'\r\n')
		f.write('\r\n')
	for app in rename:
		for f in rename[app]:
			if app[2:] == name:
				scrivi(data,f[2:],"eventi",map[element])
				print()
print(map.keys())			

