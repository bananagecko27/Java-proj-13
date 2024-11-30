[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-718a45dd9cf7e7f842a935f5ebbe5719a5e09af4491e668f4dbf3b35d5cca122.svg)](https://classroom.github.com/online_ide?assignment_repo_id=12926857&assignment_repo_type=AssignmentRepo)
# CS-2003-Lab-13

## Overview
The thirteenth lab is intended to introduce to the implementation of the iterative radix sort algorithm. The iterative radix sort algorithm sorts values starting with the least-significant digit. It's appropriate for integers. There is a recursive radix sort algorithm that sorts inputs starting with the most-significant digit. That would be an appropriate algorithm for sorting Strings.

The algorithm for the least-significant digit radix sort algorithm can be written as follows:

```pseudo
LeastSignificantDigitRadixSort(arr, n, k)
=========================================
Qs <- Queue[alphabet_size]
for kj in 0...k do
    for i in 0...n do
        d <- kjth digit of arr[i]
        enqueue arr[i] into Qs[d]
    end for
    i <- 0
    for m in alphabet_size do
        while |Qs[m]| > 0 do
            arr[i] <- dequeue from Qs[m]
            i <- i + 1
        end while
    end for
end for
end
```
> Note: `...` uses an exclusive upper-bound.

The radix sort algorithm is not as common as merge sort or quick sort, which are the most preferred sorting algorithms. However, it can be a really useful sorting algorithm. It's complexity is O(kn), where n is the size of the input and k is the maximum number of digits in any input. If it is the case that k < log(n), then radix sort becomes the faster sorting algorithm.

You should review the following files: BasicQueue.java, QueueInterface.java, RadixSort.java, and radix.txt. **BasicQueue.java** is a circular, reference-based implementation of the Queue ADT defined by **QueueInterface.java**. **RadixSort.java** is an implementation of the radix sort algorithm. **lab13.txt** contains an input list of five-digit integers. Any number smaller than 5 digits includes leading zeros.

## Assignment
Finish the implementation of the sort method in the RadixSort class. The sort method should successfully sort a sequence of five-digit numbers using a Queue-based implementation of the radix sort algorithm.

Use **TUGrader.java** to ensure that all unit tests in the provided test file(s) pass.

## Submission
The assignment is due by the end-of-day Friday of the following week.

*To submit your work, please review the **Commits** section below.*

## Grading Rubric
- [ ] (100pts) Can sort sequences of integers

## Compiling and Testing Code
Your IDE should provide tools to compile your code. If you're unfamiliar with that process, you can research it online or ask. Most developers compile their code from command line using a shell script, such as a **Makefile** or build script (**build.sh**). I've provided build scripts for you in both *Powershell* and *Bash*. Refer to the following directions on how to use these scripts based on the terminal that you're using. If you're on Windows, please use Windows Subsystem for Linux (WSL), Git Bash, or Powershell, not Command Prompt.

### Windows Users (Powershell)
- To compile your code: `./build.ps1`
- To compile and run your code: `./build.ps1 run` (forwards clargs to program)
- To compile and test your code: `./build.ps1 test` (forwards clargs to TUGrader)
- To format your code: `./build.ps1 fmt`
- To sync your code: `./build.ps1 sync`
- To submit your code: `./build.ps1 submit`
- To remove class files: `./build.ps1 clean`

### Windows Users (WSL, Git Bash), Mac and Linux Users
- To compile your code: `./build.sh`
- To compile and run your code: `./build.sh run` (forwards clargs to program)
- To compile and test your code: `./build.sh test` (forwards clargs to TUGrader)
- To format your code: `./build.sh fmt`
- To sync your code: `./build.sh sync`
- To submit your code: `./build.sh submit`
- To remove class files: `./build.sh clean`

These scripts use the following commands. Note that Windows users need to replace the colon with a semicolon in the Java classpath.
- To compile a Java file: `javac -d target -cp lib/*:src <filepath>.java`
- To execute a Java file: `java -cp lib/*:target <package-path>.<filename>`
- To format a Java file: `java -jar lib/google-java-format.jar --replace --skip-javadoc-formatting <filepath>.java`
- To remove class files: `rm -r target/*`

## Code Style
All code should follow the [Google Java style guidelines](https://google.github.io/styleguide/javaguide.html). If you find anything in the code that does not follow the style guidelines, feel free to fix it, but you are not required to do so. Only your handwritten code will be evaluated for its style. You do not need to follow the style guidelines to the letter but egregious deviations from the style guidelines will be penalized. A submission that passes all test cases but does not use an appropriate style will not receive an A for the assignment.

For those using an IDE, such as Eclipse or VS Code, the IDE should provide a formatting tool. I've included the XML specification of the Google Java Style Guidelines at `.vscode/java-google-style.xml`. You can configure your IDE to use the provided XML as its formatting rules to format your code to the Google Java Style Guidelines, which are the industry standard.

If you're working from command-line, [google-java-format](https://github.com/google/google-java-format) is an open-source formatting tool that you can use to format your files. You can use the following commands to format your code depending on your terminal.
- `./build.ps1 fmt`
- `./build.sh fmt`

## Commits
Commits should be made incrementally. Many commits are always better than few, and commits can always be squashed together later if there are too many. You should try to make a commit every time you've made tangible progress in the development of your code.

Every commit should have a commit message. The standard format for commit messages is to start with a verb in present-tense followed by a concise message (typically less than 50 characters) that summarizes the change that the commit is introducing to the repo. For example, "Updates README", "Implements Array", "Passes testGet".

Popular IDEs, such as Eclipse and VS Code, provide integrated Git tools. If you're on Windows, you can install Git Bash or Windows Subsystem for Linux (WSL). If you're on Mac or Linux, you already have git installed.

If you've just installed git, it will need to be configured. The easy way to configure git is from a terminal. Use the following commands.
- `git config --global user.name "<github-username-goes-here>"`
- `git config --global user.email "<github-email-goes-here>"`
- `git config --global pull.rebase true` (optional)
- `git config --global fetch.prune true` (optional)
- `git config --global diff.colorMoved zebra` (optional)

To sync changes made from another device, use the following command.
- `git fetch origin main`
- `git pull origin main`

To push commits from command line, use the following commands.
- `git add -A`
- `git commit -m "<your message goes here>"`
- `git push origin main`

You can also sync all changes and submit with the following commands depending on your terminal.
- `./build.ps1 submit`
- `./build.sh submit`
