# Määrittelydokumentti

Opinto-ohjelma: Tietojenkäsittelytieteen kandidaatti

Projektissa käytettävä ohjelmointikieli: Java

Koodissa käytettävä kieli (myös javadoc): englanti

Dokumentointikieli: suomi

### Ongelma

Tämän harjoitustyön tarkoituksena on tehdä ohjelma, jossa vertaillaan kahta eri reitinhakualgoritmia. Algoritmeina A-star ja IDA-star. Valitsin IDA-starin toiseksi algoritmiksi, koska siinä ei säilytetä joukkoa alustavista solmuista, joten sen muistin kulutus on pienempi kuin A-starin.A-star on kuitenkin todennäköisesti nopeampi kuin IDA-star, joten vertailu on mielenkiintoinen.

### Syötteet

Ohjelma saa syötteenä txt-muotoisia kaupunkikarttoja, missä . tarkoittaa kuljettavaa aluetta ja @ ei-kuljettavaa aluetta. Ko. karttoja saa [täältä](https://www.movingai.com/benchmarks/street/index.html) .

### Aika- ja tilavaatimukset 

Sekä A-starilla ja IDA-starilla on solmujen suhteen neliöllinen pahimman tapauksen aikavaativuus. A-starin tilavaativuus on O(b^d), missä b on maksimi haarautumistekijä ja m hakupuun syvyys. IDA-starin tilavaativuus taas on O(bm). 

Kartan lukemisen aikavaativuus on O(n²), missä n on neliön muotoisen kartan sivun pituus.

### Lähteet:

http://theory.stanford.edu/~amitp/GameProgramming/AStarComparison.html

https://algorithmsinsight.wordpress.com/graph-theory-2/ida-star-algorithm-in-general/

https://ai.stackexchange.com/questions/8821/how-is-iterative-deepening-a-better-than-a

https://en.wikipedia.org/wiki/A***_search_algorithm#Complexity

https://en.m.wikipedia.org/wiki/Iterative_deepening_A***

https://medium.com/@nicholas.w.swift/easy-a-star-pathfinding-7e6689c7f7b2
