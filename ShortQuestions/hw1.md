# Week 1 Lesson 1

Junhui Yang 04/05/2023

---

###  1.show md basic usage

```markdown
# fisrt level title
## second level title
```

**Bold text**

==Heightlight==

*Italic*

x<sup>2</sup>

x<sub>a</sub>

[link]()

```java
public static void main(String[] args){}
```

`inline code`

$\frac{latex}{2}$

1. list1
2. list2

- list3
- list4

<html><Br><Br></html>

###  2.list the git commands you learned

```shell
git init # init a git repo(repository-->source code)
git status
git add .
git commit -m "commit message"
git push origin feature-branch

git branch branch_name
git checkout branch_name
git checkout -b branch_name

git stash
git stash pop
git remote -v
```

### 3.the basic steps to init a git repo in local

```shell
git init
git add .
git status
git commit -m "message"
git status
```

### 4.clone a repo from Github

look into the remote github repo and find https-url`https://github.com/username/repository.git`

```shell
cd work_dir
git clone https://github.com/username/repository.git
```

### 5.create a new branch and checkout to that branch

```shell
cd work_dir
git branch # check current branch
git branch new-feature
git checkout new-feature
#  or just use git checkout -b new-feature to create and switch to it
git branch # check current branch
```

### 6.merge the branch_test to master branch in command

```shell
git branch # check current branch
git checkout master # switch into the base branch that new branch will be merged into
git merge branch_test
```

### 7.stash your new code 

How to **stash** your new code before leaving branch **branch_learn_stash** and pop your stash when you

checkout back to **branch_learn_stash** ? try commands way and intellij way.

#### git commands

```shell
# suppose the new code is commited to this branch
git checkout branch_learn_stash
git stash

git checkout master # go to other branch

git checkout branch_learn_stash # come back
git stash apply
```

#### IntelliJ

1. Save changes
2. Open git menu from menu bar of Intellij on Mac
3. Click on the `Uncommitted Changes`
4. Click on the `Stash Changes`
5. Switch to a different branch by clicking on the `Branches` of git menu
6. Do something else
7. Switch back to branch_learn_stash using the same method as in step 5.
8. Click on the `Unstash Changes` from `Uncommitted Changes` of git menu

### 8.how to understand **PR is based on Branch**?

A pull request is typically created to propose changes from one branch to another. The source branch contains the changes we want to merge, and the target branch is the branch we want to merge the changes into. By creating a PR, we are requesting that the changes to be reviewed by other contributers and merged into the target branch.

### 9.What is **maven** role and what it be used to do

Maven is a build automation tool to manage the build process, including the compilation of source code, packaging of compiled code into deployable artifacts such as JARs and WARs, and managing project dependencies. It manages project dependencies automatically by downloading the necessary libraries from remote repositories. Maven makes the build process consistent and repeatable.

Apart from what listed above, maven can be used for generating documentation, running tests, and deploying applications to remote servers.

### 10.the **lifecycle** of maven

The lifecycle is a sequence of build phases that represent the different stages of a project build process. There are:

1. **Clean Lifecycle**: responsible for cleaning up the project's working directory and removing any previously generated files, including pre-clean, clean, and post-clean.
2. **Default Lifecycle**: responsible for building, testing, and packaging the project. It includes the following build phases: valiate->compile->test->package->verify->install->deploy.
3. **Site Lifecycle**: responsible for generating documentation for the project. It generates documentation for the project in HTML format and then deploys the generated documentation to a remote web server.

### 11.the difference between package and install

`package` is responsible for packaging the compiled code into a distributable format such as a JAR or WAR in the `target` directory. It can only be used within the context of the current project.

`install` is responsible for installing the packaged artifact into the local repository, making it available for use as a dependency in other local projects that declares it in its Maven `pom.xml` file.

### 12.What is **plugins** in maven

Plugins are add-ons that extend the functionality of the build process.

Examples:

`maven-compiler-plugin`, `maven-install-plugin`, `maven-resources-plugin`, `maven-release-plugin`, `maven-dependency-plugin`.

