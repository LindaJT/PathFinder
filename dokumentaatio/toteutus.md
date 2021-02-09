# Toteutusdokumentti

## A-star

A-starille annetaan konstruktorissa käytettävä kartta kaksiulotteisena taulukkona, sekä aloituskoordinaatit. findPathTo-metodia kutsumalla se etsii lyhyimmän reitin parametreina annettuihin xy-koordinaatteihin. Kartan ruudut tallennetaan node-olioina binääripuuhun, missä jokaisen solmun noden f-arvo on pienempi tai yhtäsuuri kuin lapsisolmujen nodejen f-arvot. 

Vaaka- tai pystysuunnassa liikkumisen kulu on 1 ja diagonaalissa liikkumisen \sqrt{2} . 

## IDA-star
