#!/usr/bin/python
import socket 
import time
import sys
import os
import sqlite3

if len(sys.argv)<2:
	print('mancadb')
	exit(0)
	
def scrivi(data,name,des,p):
		with open(data+name.zfill(2)+"."+des+'.txt', 'w') as f:
			for row in p:
				if type ==1:#Codice=descizione,tipo,scala
					line  = str(row[3])+"="+str(row[4])+","+str(row[5])+","+str(row[9])+""
				else:
					line  = str(row[3])+"="+str(row[4])+""
				f.write(str(line)+'\r\n')
				#f.write('\r\n')
				
argom  = sys.argv[1]
con = sqlite3.connect(argom)

cur = con.cursor()
previusappmod = 0
i =  0
map = {}
'''listAPPMOD = []
for row in cur.execute('SELECT * FROM LIST_IO ORDER BY APPMOD'):
		currentappmod = hex(row[2])
		if not currentappmod in listAPPMOD:
			listAPPMOD.append(currentappmod)
		
print(listAPPMOD)'''
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
			
#print(rename)		
#exit(0)	
for row in cur.execute('SELECT * FROM LIST_IO ORDER BY APPMOD'):
		currentappmod = hex(abs(row[2]))
		currenttype = row[1]
		if not currentappmod in map:
			dizio = {}
			dizio[currenttype] = [row]
			map[currentappmod] =  dizio
		else:
			dizio = map[currentappmod]
			if currenttype in dizio:
				dizio[currenttype].append(row)
			else:
				list = [row]
				dizio[currenttype] = list
			
				
print(map.keys())
#exit(0)
data = "data/"+argom[:len(argom)-4]+"/"
os.makedirs(os.path.dirname(data), exist_ok=True)
for element in map: 
	for type in map[element]:
		t = map[element]
		p = t[type]
		des = "analog"
		#if type ==1: print(type,p[1],element[2:])
		if type ==2: des = "output"	
		if type ==0: des = "input"
		if type ==3: des = "diagnostica"
		name = element[2:]
		scrivi(data,name,des,p)
		for app in rename:
			for f in rename[app]:
				#print(f[2:])
				if app[2:] == name:
					scrivi(data,f[2:],des,p)
		'''
		with open(data+name.zfill(2)+"."+des+'.txt', 'w') as f:
			for row in p:
				if type ==1:#Codice=descizione,tipo,scala
					line  = str(row[3])+"="+str(row[4])+","+str(row[5])+","+str(row[9])+""
				else:
					line  = str(row[3])+"="+str(row[4])+""
				f.write(str(line)+'\r\n')
				#f.write('\r\n')
			'''

