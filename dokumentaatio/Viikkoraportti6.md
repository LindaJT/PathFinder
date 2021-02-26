# Viikkoraportti 6

Käytetty aika: n. 10 h

Tällä viikolla olen tehnyt lähinnä refaktorointia sekä kirjoittanut lisää testejä. Toteutin myös mahdollisuuden valita kolmen eri heuristiikkafunktion väliltä, jotta myös näiden eroja voi vertailla. Opin lisää näistä eri funktioista.

Projektiin käytettävä aika on ollut tälläkin viikolla hyvin rajattu, joten suorituskykytestaus sekä dokumentaation viimeistely jää ensi viikkoon. 

Epäselvää: Minulla on kaksi luokkaa FileReader ja PathWriter, jotka vastaavat tiedoston lukemisesta ja muokkaamisesta taulukoksi sekä reitin piirtämisestä uuteen tiedostoon. Huomasin vasta nyt, että näissä luokissa käytetään ArrayListiä. Tarvitseeko myös tällaisiin luokkiin toteuttaa omat tietorakenteet?
