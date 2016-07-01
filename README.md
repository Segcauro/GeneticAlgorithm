# GeneticAlgorithm

Die Idee ist es, ein möglichst flexibles Framework zur Erstellung genetische Algorithmen zu programmieren. Um das Framework pflegbar zu halten, sollten daher folgende Punkte bei der Programmierung beachtet werden: 

- Eindeutige Bennenung von Variablen und Objekten
- Verwendung von Vererbung und Interfaces
- Kommentierung des Codes auf Englisch
- Hilfmittel die für Entwicklertests verwendet wurden, sollten nach gebrauch entfernt werden

#Lessons Learned
- die Mutation einer DNA bei einer geringen Anzahl an DNA-Werten kann zu einem echten Problem werden, solange noch nicht mit Crossovers gearbeitet wird. Da nur DNA's mit neuen Eigenschaften in ein Set geworfen werden können, ist die mögliche Variation sehr schnell ausgeschöpft.
