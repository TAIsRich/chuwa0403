## Q1
see `ShortQuestion/README.md`

## Q2
git commit
git branch [branch name]
git switch [branch name]
git checkout [branch name]
git checkout [commit ID]
git merge [branch name]
git rebase [branch name]
git pull
git push
git stash
git stash pop
git log

##  Q3

*  `mkdir` for the repo

* `git init`



## Q4

*  `mkdir` for the repo

* `git clone [repo url]`



## Q5

`git checkout -b [branch_name]`



##  Q6

* `git checkout master`

* `git merge test`



##  Q7

* Git commands
    *  `git stash` before leaving the branch
    *  `git stach pop`when you checkout back to the branch

* ntelliJ
    * stash change:  `VCS` -> `Git` -> `stash changes`
    * pop your stash, goto `VCS` -> `Git` -> `unstash changes`



##  Q8

PR is posted when changes apply on the base branches. So, it's based on branch.



## Q9

Maven is a tool for java developers to manage the dependencies and building. The `pom.xml` file is the configuration to maven's functionalities.


##  Q10


`Validate`: validate the project is correct and all necessary information is available

`Compile`: compile the source code of the project

`Test`: test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed

`Package`: take the compiled code and package it in its distributable format, such as a JAR

`Verify`: run any checks on results of integration tests to ensure quality criteria are met

`Install`: install the package into the local repository, for use as a dependency in other projects locally

`Deploy`: done in the build environment, copies the final package to the remote repository for sharing with other developers and projects



##  Q11

The main difference between the `mvn package` and `mvn install` commands is that `mvn package` command will compile the source and will package it in its distributable formats, such as a JAR or WAR. The `mvn install` command, however, additionally to compiling the source code and packaging it into a JAR or a WAR, it will also install the package into the local repository, for use as a dependency in other projects locally.



##  Q12

Maven is actually a plugin execution framework where every task is actually done by plugins.

`maven-javadoc-plugin`

`maven-compiler-plugin`

`maven-dependency-plugin`

## Q13

See Maven Project file