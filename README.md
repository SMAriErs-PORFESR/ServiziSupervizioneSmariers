# ServizioSupervisione

<!--[![Build Status](https://travis-ci.org/stingray-PORFESR2017/Provider_di_Servizi.svg?branch=master)](https://travis-ci.org/stingray-PORFESR2017/Provider_di_Servizi)

[![License: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

[![Coverage Status](https://coveralls.io/repos/github/stingray-PORFESR2017/Provider_di_Servizi/badge.svg?branch=vDevel)](https://coveralls.io/github/stingray-PORFESR2017/Provider_di_Servizi?branch=vDevel)-->

[![Sito Internet](https://img.shields.io/badge/ISTI-smariers-blue.svg)](https://smariers.isti.cnr.it)

[![SemVer](https://img.shields.io/badge/SemVer-0.0.1-ff69b4.svg)](https://semver.org/lang/it/)


Servizio Supervisione (PSS) del Progetto della Regione Toscana **Smart Railway Infrastructures: Efficiency, Reliability and Safety (SmaRIERS)** POR FESR Toscana 2014-2020
 Bando 1 “Progetti strategici di ricerca e sviluppo” del POR FESR 2014-2020 (azione 1.1.5 sub-azione a1) - Decreto 7.10.2021 n. 18043




## Partners of Stingray

|  #  | Name                                         | Short name    | Country     |
| --- | -------------------------------------------- | ------------- | ----------- |
|  1  | ECM                                          | ECM           | Pistoia     |
|  2  | CONSIGLIO NAZIONALE DELLE RICERCHE           | ISTI-CNR      | Pisa        |
|  3  | Dipartimento di Ingegneria dell'Informazione | UNIPI         | Pisa        |
<!--|  4  | DMG Engineering s.r.l.                       | DMG           | Pistoia     |
|  5  | ELFI s.r.l.                                  | ELFI          | Pistoia     |
|  6  | C.T. Elettronica S.r.l.                      | CTE           | Firenze     |-->

## Information

Information   | Value
------------- | --------
Component     | Servizio Supervisione  (SSP)
Partner       | ISTI-CNR
WP            | 3
Responsible   | Giorgio O. Spagnolo <spagnolo at isti.cnr.it>
Roadmap       |
Wiki          |

# The platform
## Main Dependencies
Be sure the following tools have been installed on your system before to start :
 * git
 * maven
 * curl
 * unzip
 * build-essential (in Ubuntu, or similar)
 * Java 8
 * Bash Shell

## Build
First of all, clone the repository.

```
git clone https://github.com/SMAriErs-PORFESR/ServiziSupervizioneSmariers.git
```

Then, once cloned, you can trigger a build with the `build` script in the root directory.
```
mvn install
```

## Run it!
After the build.  You should be able to run the platform with the
following command

```
mvn run
```

You can also stop it with the following command.
```
 
```
or restart it (it will stop every component then start it again)
```
 
```

<!---Once the platform is started, access it on `http://localhost:9090/xwiki` in your web-browser.-->

## Components
PRV platform is a set of components, each one is in an independent
directory.  To know the exact list of components in the platform, you can look
into the `components` file.
