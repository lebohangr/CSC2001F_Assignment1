JAVAC = /usr/bin/javac
.SUFFIXES: .java .class

SRCDIR=src
BINDIR=bin
DOCDIR=doc


default:
	$(JAVAC) -d $(BINDIR) $(SRCDIR)/*.java
docs:
	javadoc -d $(DOCDIR) $(SRCDIR)/*.java
clean:
	rm $(SRCDIR)/*.class
run:
	java -cp src LSBSTApp >> outputWithMake
run2:
	java -cp src LSBSTApp 5 21 42 >> outputWithMake
run3:
	java -cp src AVLApp >> outputWithMake
run4:
	java -cp src AVLApp 7 12 23 >> outputWithMake
