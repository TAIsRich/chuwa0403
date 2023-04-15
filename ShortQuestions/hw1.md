Sorry for the late submission. My computer's broken this week. I just got a new laptop on Sunday.

### 1. Markdown basic syntax
# heading

**bold**

_Italic_

>quote

```
code block
```
Create inline [link](https://www.google.com)

### 2. git command
```
git init
git add .
git commit -m
git branch
git checkout
git status
git push origin master
```
### 3. basic steps to init local repo
```
cd [working directory]
git init
```
### 4. clone a repo from Github
```
git clone [ssh or https address]
```
### 5. create and checkout to new branch
```
git branch [branch name]
git checkout [branch name]
git branch -b [branch name]
```
### 6. merge branch_test to master
```
git checkout master
git merge branch_test
```
### 7. stash code
```
git stash
git stash pop
```
### 8. How do you understand PR is based on Branch?
When we create a PR, it indicates a branch to compare changes to another.
### 9. maven role
Maven is a project management tool, we use maven to manage our project's lifecycle based on POM(project object model). 
### 10. maven lifecycle
maven build/default lifecycle includes these phases:prepare resourses, validate, compile, test, package, install, deploy
### 11. difference between package and install
package: compiled code is packaged to JAR/WAR etc.
install: install packages in local repo
### 12. plugins 
All the phases in lifecycle are accomplished by plugins, such as dependency, complier, jar, war, surefire, install plugins.
### 13. create a MavenProject 
### 14. Do Code Review









