### 1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md
> I've learned about the basic writing and formatting syntax, will use them in thisMarkDown file, also see examples in README.md

### 2. practice git using the platform. list the git commands you learned
> git commit, git branch name, git checkout name, git checkout -b name, git merge name, git rebase name

### 3. What is the basic steps to init a git repo in you local ?
> - Create directory or go into the directory where the proejct at
> - git init
> - write something in the project
> - git add
> - git commit

### 4. How to clone a repo from Github ?
> git clone url

### 5. How to create a new branch and checkout to that branch ?
> git branch name -> git checkout name; or git checkout -b name

### 6. How to merge the branch_test to master branch in command ? show me the commands
> - git checkout main
> - git merge branch_test
> - git checkout branch_test
> - git merge main

### 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.
> - git stash
> - git stash pop
> - "Git Stash" action in the "Git" menu

### 8. How do you understand PR is based on Branch?
> A pr I understand is when a branch is ready to merge into another branch and is ready for others to review, 
> when a PR is raised, the system would compare how many new commits have been made to the feature branch

### 9. What is maven role ? what it be used to do ?
> Maven is chiefly used for Java-based projects, helping to easily download add and remove dependencies, 
> which refers to the libraries or JAR files. The tool helps get the right JAR files for each project as 
> there may be different versions of separate packages. _Roles: Manage dependencies, build project, documentation, reporting_

### 10. What is the lifecycle of maven? could you tell me the details ?
> - validate - validate the project is correct and all necessary information is available
> - compile - compile the source code of the project
> - test - test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
> - package - take the compiled code and package it in its distributable format, such as a JAR.
> - verify - run any checks on results of integration tests to ensure quality criteria are met
> - install - install the package into the local repository, for use as a dependency in other projects locally
> - deploy - done in the build environment, copies the final package to the remote repository for sharing with other developers and projects.

### 11. what is the difference between package and install in maven lifecycle ?
> Those are two different phases in mave build lifecycle, package will take the compiled code and package it into JAR, install will install the packag
> into the local repository.

### 12. What is plugins in maven, list some plugins.
> Maven is actually a plugin execution framework where every task is actually done by plugins. Maven Plugins are generally used to:
> - create jar file
> - create war file
> - compile code files
> - unit testing of code
> - create project documentation
> - create project reports  
> Some plug-ins:
> - clean:  Cleans up target after the build. Deletes the target directory.
> - compiler: Compiles Java source files.
> - surefile: Runs the JUnit unit tests. Creates test reports.
> - jar: Builds a JAR file from the current project.
> - war: Builds a WAR file from the current project.
