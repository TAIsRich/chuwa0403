# homework 1
## 1
see [README.md](shortQuestions/README.md)
## 2
[LearnGitBranching](https://github.com/pcottle/learnGitBranching)
```
git commit
git branch my-branch
git merge my-branch
git branch -f main HEAD
git reset HEAD~1
git reverse 
git rebase
git cherry-pick target-commit
git rebase -i HEAD~3
```

## 3 
### Basic steps to init a git repo
Without GitHub:
- create a directory to contain the project `mkdir my-project`
- go into the new directory `cd my-project`
- Type `git init .`
- create new branch if needed: `git checkout -b my-new-feature`
- Start writing code ...

## 4
### Clone a repo
With GitHub:
- create a repository on GitHub and clone the repo to local by `git clone xxxx`
- go into the project, create new branch and start writing code ...

## 5
create a new branch: `git branch new-branch`
checkout to the branch: `git checkout new-branch`
create and checkout: `git checkout -b new-branch`

## 6
merge:
```
git checkout master
git pull
git checkout branch_test
git merge master
```

## 7
To stach, run: `git stash `
When checkout to the branch, run: `git stash pop`

Use IntelliJ:

GIT -> uncommited changes -> stash changes 
## 8
Pull Request is a live request. It only relates to one branch. So if there is something change in the branch and after commit, the PR always asking to pull new contents in the branch now.

## 9

Maven is a project management tool. It abstracts project development and management process into a project object model. This will allow developers to comprehend the complete state of a development effort in the shortest period of time.

Maven is used for Java-based projects. It is used to build project, help manage dependencies.

## 10
[Build Lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html#:~:text=There%20are%20three%20built%2Din,of%20your%20project's%20web%20site.)

A build lifecycle is well-definde sequence of phase, which define the order in which the goals are to be executed.

There are three built-in build lifecycles: default, clean and site. 

The default lifecycle handles your project deployment, the clean lifecycle handles project cleaning, while the site lifecycle handles the creation of your project's web site.

## 11
Difference between package and install in maven lifecycle:

Package and install both are the phases of default lifecycle. Package is to create the JAR/WAR package as mentioned in tge packaging in POM.xml. Install is to install the package in local/remote maven repository.

## 12
Plugins allow for the reuse of common build logic across multiple projects:

- Maven Clean plugin
- Maven Site Plugin
- Maven Dependency Plugin
