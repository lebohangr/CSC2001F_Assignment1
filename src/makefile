JAVAC=/usr/bin/javac
SRCDIR=src
BINDIR=bin
docdir=./docs

default:
	$(JAVAC) -d $(BINDIR) $(SRCDIR)/*.java
clean:
	rm $(SRCDIR)/*.class
run:
	java -cp bin LSBSTApp
run2:
	java -cp bin LSBSTApp 5 21 42
run3:
	java -cp bin AVLApp
run4:
	java -cp bin AVLApp 7 12 23
docs:
javadoc -d $(docdir) $(SRCDIR)/*.java
