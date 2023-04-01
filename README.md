# Zadanie 2 - WaterPipes
B-OOP 2023

_English version of the assignment can be found at the end of this document._

Vašou úlohou je naprogramovať hru ako oknovú aplikáciu v jazyku Java s pomocou knižníc AWT a Swing. Používateľské rozhranie aplikácie má pozostávať z:

* canvasu (alebo JPanel) - ktorý bude tvoriť hernú plochu
* bočné menu (jeho umiestnenie si zvoľte sami, teda môže byť aj hore, alebo dole)
## Základná pozícia
Po spustení aplikácie vygenerujte pomocou algoritmu [náhodného prehľadávania do hĺbky](https://www.baeldung.com/cs/maze-generation#dfs-maze) cestu z trubiek, ktoré pôjdu od štartu po cieľ a vykreslite ju na canvas.
Hra bude začínať na hracej ploche veľkosti 8x8 polí, a bude možné jej veľkosť meniť (minimálne 3 veľkosti).

Cieľom hry je prepojiť štart a cieľ pomocou správneho otočenia trubiek. Ak sa nám podarí cestu správne otočiť, po jej skontrolovaní chceme prejsť do ďalšieho levelu (nanovo vygenerovať hraciu plochu).
Štart a cieľ hry sa náhodne generuje, vždy na protiľahlej strane hernej plochy (Ak je štart vľavo, cieľ musí byť vpravo, pozíciu treba vybrat náhodne). Trubky po vygenerovaní cesty musia byť náhodne otočené.

## Požiadavky

Hra má byť hrateľná pomocou myši, keď myšou prejdem ponad pole, dané pole sa musí zvýrazniť. Ak sa na danom poli nachádza trubka, pomocou kliknutia myši ju viem otočiť.
V menu sa má nachádzať:
* informácia o tom, v ktorom som leveli, a veľkosť plochy.
* komponent pomocou ktorého je možné zmeniť veľkosť hracej plochy (iba na hodnoty 8 a vyššie). Konkrétny komponent si môžete zvoliť sami, napríklad jeden z: Slider, JTextField, JComboBox. Pri zmene veľkosti vždy resetujem hru.
* tlačidlo, ktorým vieme hru zresetovať.
* tlačidlo, ktorým vieme skontrolovať správnosť našej cesty.

Stlačením klávesy R na klávesnici vieme tiež hru reštartovať, a pomocou klávesy ESC vypnúť, a pomocou tlačidla ENTER skontrolovať správnosť našej cesty.

Pri kontrole správnej cesty vyznačiť od štartu všetky správne otočené trubky až po prvú chybnú.

Pri zadaní môžte používať LOMBOK.
## Hodnotenie

Zadanie je hodnotené 15 bodmi. 5 bodov je za funkčnosť zadania, 5 bodov za Princípy OOP a 5 bodov za správne používanie knižnice SWING. **Odovzdaný program musí byť skompilovateľný, inak je
hodnotený 0 bodmi**. Skompilovateľnosť zadania kontroluje aj github pipeline. Hlavný dôraz v hodnotení sa kladie na objektový prístup a princípy,
okrem iného:

* vhodné pomenovanie tried a metód v jednotnom jazyku (názvy tried s veľkým počiatočným písmenom, názvy metód s malým),
* vhodné použitie modifikátorov prístupu (public, private, poprípade protected) na obmedzenie prístupu k metódam a atribútom,
* využitie dedenia a polymorfizmu,
* použitie výnimiek na ošetrenie nedovoleného správania (nehádzať a nezachytávať všeobecnú triedu Exception),
* nepoužívajte nested classy,
* vo vašich triedach nevytvárajte statické metódy ani nekonštantné statické premenné (v zadaní nie sú potrebné),
* v hlavnej triede (main) nevytvárajte žiadnu logiku, iba vytvorte nový objekt.
* vo svojom riešení môžete použiť knižnicu lombok a jej anotácie. Potrebná dependencia je už pridaná v _pom.xml_ súbore.

Niektoré z vecí, za ktoré sme minulý rok strhli po 0,5 - 1 bode:

* Po spustení je okno prázdne, vykreslí sa až po resize
* Nie je nastavená počiatočná velkosť okna
* Nie je naimplementovaný niektorý z listenerov (možnosť stratiť až 3 body)
* Nefunguje reset
* Chybné vykreslovanie
* Neodchytené exceptions
* Nenastavený exit okna
* Nesprávna detekcia výhry
* Kód v main metóde
* Nevyužitie OOP princípov
* Po resete prestane fungovať niektorý z listenerov
* Otvaranie noveho okna pri resete
* Listenery ako Nested Triedy
* Hra sa nedá dohrať
* Frame.setVisible je zavolaný moc skoro

Prípadne sú pri nedostatočnej implementácií struhnuté body za OOP za nedostatočnú implementáciu.

**Pri zadaní sa kontroluje originalita zadaní, a všetky zadania so zhodou vyššou ako 65% sú hodnotené 0 bodmi.**

## Odovzdávanie
Zadanie si naklonujte z repozitára zadania výhradne pomocou poskytnutej linky cez GitHub Classroom (pokiaľ si vygenerujete vlastný repozitár pomocou tlačidla "Use this template" z template repozitára, my váš repozitár neuvidíme a nebudeme ho hodnotiť!). Svoje vypracovanie nahrajte do pre vás vytvoreného repozitára pre toto zadanie pomocou programu Git (git commit + git push).
Skontrolujte si, či sa váš repozitár nachádza pod skupinov **Interes-Group**, inak nemáme prístup ku vášmu repozitáru a zadanie sa nepovažuje za odovzdané. Vypracovanie môžete "pusho-vať" priebežne. Hodnotiť sa bude iba _master_ branch. Zadanie je nutné vypracovať do **23.4.2023 23:00**.

V projekte upravujte iba súbory v priečinku _src/main_ a jeho podpriečinkoch. Ostatné súbory je upravovať zakázané (predovšetkým súbory _pom.xml_, súbory obsahujúce github pipeline-y a súbory obsahujúce automatizované testy).

Vo svojom github účte si nastavte svoje meno alebo AIS login (settings > profile > name), aby bolo možné priradiť riešenie ku študentovi. **Pokiaľ nebude možné spárovať študenta s riešením je zadanie hodnotené 0 bodmi!**

# Assignment 2 - WaterPipes
B-OOP 2023

Your task is to create the game as a window application in Java using the AWT and Swing libraries. The user interface of the application should consist of:

* canvas (or JPanel) - which will draw the game board
* side menu (you can choose the placement of this menu, it can also be on the top, or at the bottom of the window)
## Basic position
After starting the application, generate a path from the pipes that will go from the start to the destination using the algorithm [random search in depth](https://www.baeldung.com/cs/maze-generation#dfs-maze) and draw it on the canvas.
The game will start on a playing board of 8x8 squares, and it will be possible to change its size (minimum 3 sizes).

The goal of the game is to connect the start and the finish line by turning the pipes correctly. If we manage to turn the path correctly, after checking it we want to go to the next level (generate a new the playing board).
The positions of the start and the finish line are generated randomly, always at the opposite sides of the board (if the start is on the left, the finish must be on the right, the positions must be chosen randomly). After the path is generated the pipes must be rotated randomly.    

## Requirements

The game is supposed to be playable with the mouse, when I hover the mouse over a field, that field must be highlighted. If there is a pipe on the field, I can rotate it by clicking the mouse.
The menu should include:
* information about the level I am in and the size of the area.
* component with which it is possible to change the size of the playing area (only to values 8 and above). You can choose a specific component yourself, for example one of: Slider, JTextField, JComboBox. I always reset the game when resizing.
* the button with which we can reset the game.
* button with which we can check the correctness of our journey.

By pressing the R key on the keyboard, we can also restart the game, and use the ESC key to turn it off, and use the ENTER key to check the correctness of our path.

When checking the correct path, mark from the start all the correctly turned pipes up to the first faulty one.

You can use LOMBOK.

## Grading
You can get 15 points for this assignment. 5 points are given for fulfilling the outlined rules of the game, 5 points are given for complying with OOP principles, 5 points are given for correct usage of the AWT and Swing libararies.
**The program must be able to compile, otherwise 0 points are given for the assigment.**
The github pipeline checks whether the program can be compiled. The main focus during grading is put on object-oriented approach and OOP principles used by the solution.
Including, but not limited to:
* appropriate naming of classes, methods and variables in a single language (class names starting with a capital letter, method names starting with a lowercase letter),
* appropriate use of access modifiers (public, private, or protected) when restricting access to class methods and attributes,
* the use of inheritance and polymorphism,
* usage of exceptions when handling undesired behavior (do not catch or throw the instances of the generic Exception class),
* don't use nested classes,
* don't use static methods, or non-constant static variables (you don't need them to complete the assignment),
* don't put any logic into the main method and its class. The main method should only be used to create a new object,
* you can use the lombok library and its annotations in your solution. The neccessary dependency is already present in the pom.xml file.

Issues that resulted in a 0.5 - 1 point reduction last year:

* The application shows an empty window when it starts and the content is displayed only after the window is resized
* The initial dimensions of the window are not set
* Some of the required listeners are not implemented
* The game cannot be reset
* Drawing glitches
* Uncaught exceptions
* The program does not exit, when the window closes
* The win condition is not checked correctly
* Code in the main method
* Lack of OOP principles
* Some of the listeners are broken after the game resets
* A new window is opened when the game resets
* Listeners are implemented with nested classes
* The game cannot be finished
* Frame.setVisible is called too early

If the assignment lacks a substantial part of the specified functionality additional points are substracted.

**The originality of the code is checks, all assignments with a more than 65% match are awarded with 0 points.**

## Handing in the assigment

Clone the assignment from the repository created from this template by the provided link trough GitHub Classroom (if you create your own repository with the "use this template" button, we won't be able to see your repository, and we won't be able to grade it!). Upload your solutions to your repository using the Git version control system (git commit + git push).

Make sure, that your repository was created under the **Interes-Group** group, otherwise we won't be able to access your repository, and the assignment will not be graded.

You can push commits to the repository while you work - you don't have to push everything at once. Only the code in the _master_ branch will be graded. You have until **23.4.2023 23:00** to complete the assignment.

Only edit files in the _src/main_ folder or its sub-folders. You mustn't change any other files in the repository (especially the _pom.xml_ file, and the github pipeline files).

You have to have your name set in your github account (settings > profile > name), so that we can match students with their assignments. **If we are unable to match a student with their assignment, the student will receive 0 points for the assignment!**