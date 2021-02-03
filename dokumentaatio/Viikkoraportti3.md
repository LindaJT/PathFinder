# Viikkoraportti 3

Käytetty aika 22 tuntia. 

Tällä viikolla jatkoin A-star toteutuksen hiomista sekä lisäsin IDA-star toteutuksen. Erityisesti A starin toiminnassa on ollut ongelmia, joiden selvittelyssä on mennyt suurin osa tämän viikon projektiin käyttämästäni ajasta. A-star vaikuttaa toimivan oikein pienillä kartoilla, mutta isoilla kartoilla se on todella hidas, eikä anna lyhintä reittiä. IDA-star taas vaikuttaa toimivan hyvin ja nopeasti isoillakin kartoilla. Vaihdoin ArrayListin PriorityQueuhun A-starin toteutuksessa, mutta se ei nopeuttanut algoritmin toimintaa. 

Lisäsin diagonaaliselle liikkumiselle kuluksi ehdotetun sqrt(2). Heuristiikkafunktiossa käytän löytämääni kahdeksaan suuntaan liikkumiseen tarkoitettua varianttia.

Käyttöliittymään lisäsin IDA-star-napin sekä kummallekin algoritmille tekstikentät, joihin tulee algoritmiin kulunut aika. Jatkoin myös testien kirjoittamista.

Tällä viikolla opin paljon lisää valitsemieni algoritmien toiminnasta, kun hioin niitä ja etsin tietoa. 

Ohjelma on edistynyt mielestäni ihan ok, on tosin turhauttavaa, kun suurin osa ajasta on kulunut algoritmien hiomiseen, eivätkä ne vieläkään toimi optimaalisesti. Seuraavalla viikolla aion keskittyä omien tietorakenteiden tekemiseen ja toivon, että pienen tauon jälkeen osaan katsoa aikaisempaa koodiani uusin silmin.
