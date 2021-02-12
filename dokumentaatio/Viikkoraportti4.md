# Viikkoraportti 4

Käytetty aika: n. 22 h

Tällä viikolla muokkasin A staria niin, että nyt se vaikuttaisi toimivan oikein ja nopeasti. Testasin sen toimintaa berliinin kartan eri skenaarioilla ja se palautti aina oikein etäisyyden. Toteutin A starille tietorakenteeksi MinHeap, joka toimii priorityQueuen kaltaisesti ja IDAstarille NeighborsList noden naapureiden tallentamiseen. IDA starin kanssa oli tällä viikolla ongelmia, mutta sain sen toimimaan ok. Tällä hetkellä se vaikuttaa toimivan hyvin lyhyillä etäisyyksillä (alle 30), mutta pitkillä etäisyyksillä tai laajalla tyhjällä alueella, missä ei ole esteitä, se on todella hidas. 

Aloitin myös toteutus- ja testausdokumenttien kirjoittamisen sekä tein lisää yksikkötestejä. Muutin koodia hieman siistimmäksi. Muutin kartan lukemisen niin, että kartalle lisätään "seinät" ympärille, jolloin naapureita läpikäydessä ei tarvitse tarkastaa ollaanko reunassa.

Tällä viikolla opin erityisesti omien tietorakenteiden tekemisestä. IDA starin parissa on mennyt paljon aikaa ja ei edelleenkään ole valmis, mutta edistystä kuitenkin.

Seuraavalla viikolla jatkan omien tietorakenteiden tekemistä, testien kirjoittamista ja dokumentaation laajentamista. Tarkoitus olisi myös vielä hioa IDA staria paremmaksi.
