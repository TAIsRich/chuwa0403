# Homework1

## 1. 
See [README.md](./README.md)

## 2.
git commit -m "new message"

git checkout

git merge 

git rebase main: rebase current base to main

git checkout history-mark: separate head from the history commit

git checkout head^: use after separate head, move the head to previous commit

git checkout main^: the previous commit from main branch

git branch -f main HEAD~3: point main to the third level commit

git reset HEAD~num: used local to reset to previous commits

git revert HEAD~num: use to reset remote branch, first reset and push

git cherry-pick c2 c4: pick commits to current head

git rebase -i HEAD~4: pick several commits and reorder it to commit

## 3. What is the basic steps to init a git repo in you local ?
Create a directory in the local;

Navigate into the directory and type git init.

## 4. How to clone a repo from Github ? 
Get the URL of the remote repository;

Navigate into the directory that you want to clone and type git clone url.

## 5. How to create a new branch and checkout to that branch ? 
Create it directly from gtihub navigate bar and type the new branch and create, or in the command line type git checkout -b new branch name

## 6. How to merge the branch_test to master branch in command ? show me the commands
```
git checkout master
git pull 
git merge branch_test
(solve some conflicts here)
git push origin master
```
## 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way
```
git stash

git stash pop
```
IntelliJ: GIT -> uncommited changes -> stash changes

## 8. How do you understand PR is based on Branch ?
A PR indicates a branch to review compared to another branch. The system will evaluate how many new commits have been made to the feature branch since the time it has been branched off the Master one.

## 9.  What is maven role ? what it be used to do ? 
Maven is a project management tool based on POM. Its goal is to allow a developer to comprehend the complete state of a development effect in short time of period. 

It is used for projects build, dependency and documentation. 

## 10. What is the lifecycle of maven? could you tell me the details ? 
+ validate - validate the project is correct and all necessary information is available;
+ compile - compile the source code of the project;
+ test - test the compiled source code using a suitable unit testing framework;
+ package - take the compiled code and package it in its distribute formate, e.g. .JAR;
+ verify - run checks on results of integration tests to ensure quality criteria;
+ install - install the package into local repository for use as a dependency for other projects;
+ deploy - done in the build environment, copies the final package to the remote repository for sharing with other developers and projects;
+ clean - project cleaning;
+ site - handles the creation of your project's web site.

## 11. what is the difference between package and install in maven lifecycle ?
'Package' takes the compiled code and package it in its distribute formate, e.g. .JAR, while 'install'  install the package into local repository for use as a dependency for other projects.

## 12. What is plugins in maven, list some plugins.
Maven allows for the reuse of common build logic across multiple projects.  Plugins are used to: create jar files, create war files, compile code, unit test code, create project documentation.

+ Maven clean plugin
+ Maven compiler plugin
+ Maven install plugin
