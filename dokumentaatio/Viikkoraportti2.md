# Viikkoraportti 2

Käytetty aika: 20 tuntia

Tällä viikolla aloitin UI:n ja A-starin toteutuksen. Päätin tehdä käyttöliittymän jo nyt, koska ajattelin, että se helpottaa ohjelman testausta toteutuksen aikana. Tein visualisoinnin aluksi niin, että kartta ja reitti tulostuu terminaaliin. Tämä oli melko epäkäytännöllistä isoilla kartoilla, joten muutin sen niin, että reittiä haettaessa, ohjelma kirjoittaa kartan ja reitin uuteen tiedostoon. Lisäsin projektiin jacocon ja checkstylen ja aloitin testien kirjoittamisen. 

Ohjelma edistyi mielestäni hyvin tällä viikolla, mutta käytin siihen myös paljon aikaa. Aikaa meni erityisen paljon siihen, että mietin, miten karttojen luku ja käsittely tapahtuu. Aikaa meni myös yllättävän paljon esim. checkstylen konfiguroimiseen ja testien kirjoittamiseen. 

Tällä viikolla tuli kerrattua paljon aikaisemmilla kursseilla käytyjä asioita esim. JavaFx:stä ja tiedostojen lukemisesta ja niihin kirjoittamisesta. A-starista tuli tietenkin etsittyä paljon tietoa, joten siitä oppi samalla. Päätin, että ohjelmassa on sallittua liikkua kartalla myös diagonaalisesti. Tämä aiheutti pohtimista siitä, miten noden h-arvo lasketaan. Valitsemassani ratkaisussa diagonaalisella kulkemisella ei ole isompaa kustannusta kuin horisontaalisesti tai vertikaalisesti kuljettaessa.

Vaikeuksia tuotti erityisesti tuo jo aikaisemmin mainittu karttojen lukeminen ja käsittely. En tiedä onko tekemäni tapa millään tapaa "oikea" tai järkevä. Lisäksi haluaisin poistaa UI- ja Main-luokat jacocon raportista, mutta tässä en ole vielä onnistunut.

Ensi viikolla minun tulisi toteuttaa IDA-star sekä aloittaa omien tietorakenteiden toteutus. Visualisointia voisi myös parantaa niin, että kartalla näkyisi reitin lisäksi myös kaikki vieraillut ruudut.
