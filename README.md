# WC-ALPHA
This is a custom version of the Unix command line tool wc.

## Usage

### Example
This is an example of the usage of the command line tool.
```bash
java -jar wc-alpha-1.0-SNAPSHOT.jar -l myfile.txt
```
p.s. `-l` stands for lines

You can set an alias for the command line tool
```bash
alias wc='java -jar wc-alpha-1.0-SNAPSHOT.jar'
```
You can change "wc" to the name you want to call the command line tool

Additionally you can place the alias line in your .bashrc to make it permanent

### Easy run example
In order to test the program easily you can use the following commands:

Enter the playground directory
```bash
cd playground
```

Then run the reload script
```bash
./reload.sh
```

The code you've run above counts the number of lines, words and bytes in the given file placed
in the playground directory.

### Available Options
-c - Count the number of bytes
-l - Count the number of lines
-w - Count the number of words
-m - Count the number of characters

## License
MIT
