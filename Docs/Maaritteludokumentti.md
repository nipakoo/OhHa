Kontinpurkaja 2000


Ratkaistava ongelma ja käyttäjän syötteet:

Käyttäjä syöttää ohjelmalle vastaanotettavan kontin tuotteiden EAN-koodit sekä kyseisen tuotteen ulkopakkauksen koon, sekä tehdäänkö tavallisia vai korkeita lavoja. Käyttäjällä on myös mahdollisuus valita tietty määrä pelivaraa jätettäväksi laatikoiden väliin esimerkiksi sen varalta, että laatikot ovat pullistuneita johonkin suuntaan. Näiden tietojen perusteella ohjelma laskee miten kukin tuote on paras asettaa EUR- sekä FIN-lavalle ja kuinka monta lavaa tarvitaan kyseiselle tuotteelle yhteensä. Tämän jälkeen käyttäjä valitsee kullekin tuotteelle käytettävän lavatyypin ja ohjelma kertoo kuinka monta kutakin lavaa tarvitaan yhteensä koko kontin tyhjentämiseen. Jokaisen suoritetun laskutoimituksen jälkeen ohjelma tallentaa kyseisen tuotteen laskutulokset muistiin, jolloin seuraavan kerran vastaanottaessa kyseistä tuotetta, ei ohjelman tarvitse laskea mitään, vaan se voi hakea muistista kyseisen tuotteen tiedot.

Toteutettavat tietorakenteet ja algoritmit:

Ajattelin aloittaa toteuttamalla algoritmin joka generoi eri permutaatiot tavoille asettaa laatikot lavoille ja palauttaa tuloksen, jolla saadaan mahtumaan eniten.  Toteutan myös AVL-puun, johon laskutulokset tallennetaan ja tietojen käsittelyä varten haku-, lisäys- ja poisto-algoritmit. Lähden liikkeelle permutaatioiden generoinnista sen tuottavan varman tuloksen takia ja koska uskon, ettei kaikkien mahdollisuuksien läpikäynnistä johtuva hidastuminen haittaa, sillä lava on kuitenkin suht pieni alusta. Myöhemmin mahdollisesti tutustun aiheeseen syvemmin, kun on aikaa ja parantelen toteutustani. AVL-puun aion toteuttaa, sen kätevyyden ja nopeuden takia. En myöskään ole kokonaista puurakennetta ennen toteuttanut ja aihe on mielenkiintoinen. AVL-puun puolesta puhuu myös se, että esimerkiksi punamusta puuhun verrattuna vaikkakin lisäys ja poisto ovat hitaampia AVL-puussa, on haku nopeampi, mikä on mielestäni tässä sovelluksessa tärkeintä.

Tavoitteena olevat aika- ja tilavaativuudet:

En ole vielä ehtinyt hahmotella algoritmia, jolla lähestyn laatikkojen sijoittamistapaa, mutta nopea ensimmäisestä versiosta ei tule vaan aikavaativuus venyy varmasti eksponentiaaliseksi. Laatikot voi asettaa käytännössä kuudella eri tavalla lavalle, mikä aiheuttaa algoritmille huomattavasti laskettavaa. Aion lähestyä ongelmaa rekursiivisesti ja pyrkiä saamaan aikaan toimivan algoritmin. Myöhemmin pyrin tutustumaan ongelmaan tarkemmin ja parantelemaan algoritmiani.

AVL-puun lisäys: aikavaativuus = O(log(n)), tilavaativuus = O(1)
AVL-puun haku: aikavaativuus = O(log(n)), tilavaativuus = O(1)
AVL-puun poisto: aikavaativuus = O(log(n)), tilavaativuus = O(1)

Lähteet:

Keväällä 2013 järjestetyn Tietorakenteet ja algoritmit –kurssin luentomateriaali
http://www.cs.helsinki.fi/u/floreen/tira2013/tira.pdf

http://www.dtic.mil/cgi-bin/GetTRDoc?AD=ADA517366#page=13
