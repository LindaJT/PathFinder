# Toteutusdokumentti

## A-star

A-starille annetaan konstruktorissa käytettävä kartta kaksiulotteisena taulukkona, sekä aloituskoordinaatit. findPathTo-metodia kutsumalla se etsii lyhyimmän reitin parametreina annettuihin xy-koordinaatteihin. Kartan ruudut tallennetaan node-olioina binääripuuhun, missä jokaisen solmun noden f-arvo on pienempi tai yhtäsuuri kuin lapsisolmujen nodejen f-arvot. 

Vaaka- tai pystysuunnassa liikkumisen kulu on 1 ja diagonaalissa liikkumisen \sqrt{2} . 

## IDA-star

IDA-star saa myös konstruktorissa kartan kaksiulotteisena taulukkona ja aloituskoordinaatit ja findPathTo-metodille annetaan parametrina loppukoordinaatit. Alussa kynnysarvona on arvioitu etäisyys aloituspisteestä maalipisteeseen. Jokaisella iteraatiolla toteutetaan syvyyshaku ja jätetään pois polut, joiden f-arvo (g+h) ylittää annetun kynnysarvon. Kullakin iteraatiolla seuraavaan iteraatioon käytettävä kynnysarvo on kaikkien nykyisen kynnysarvon ylittäneiden arvojen vähimmäiskustannus (f).

Iteraatioissa sen hetkisen noden naapurit lisätään NeighborsList-tietorakenteeseen addNeighborsToOpenList-metodissa.

Vaaka- tai pystysuunnassa liikkumisen kulu on 1 ja diagonaalissa liikkumisen \sqrt{2} .

## Suorituskykytestaus

Suorituskykyä testataan Moving AI Labin Berliinin kartalla vertailemalla A-starin ja IDA-starin suoritusnopeuksia eri syötteillä. Syötteet ovat Moving AI Labin skenaarioista. 
