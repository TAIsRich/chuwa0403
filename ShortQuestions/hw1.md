## 1 Learn MarkDown
### Ans:
please check README.md

## 2 practice git
### Ans:
`git commit` Create a new commit containing the current contents of the index and the given log message describing the changes.

`git branch [branch name]` this will create the new branch, but it will not switch the working tree to it

`git switch [branch name]` switch to new branch

`git checkout [branch name]` To prepare for working on branch, switch to it by updating the index and the files in the working tree, and by pointing HEAD at the branch. Local modifications to the files in the working tree are kept, so that they can be committed to the branch.

`git checkout [commit ID]` Prepare to work on top of commit, by detaching HEAD at it (see "DETACHED HEAD" section), and updating the index and the files in the working tree. Local modifications to the files in the working tree are kept, so that the resulting working tree will be the state recorded in the commit plus the local modifications.

`git merge [branch name]` Incorporates changes from the named commits (since the time their histories diverged from the current branch) into the current branch. This command is used by git pull to incorporate changes from another repository and can be used by hand to merge changes from one branch into another.

`git rebase [branch name]` If branch is specified, git rebase will perform an automatic git switch <branch> before doing anything else. Otherwise it remains on the current branch.

`git pull` Incorporates changes from a remote repository into the current branch. If the current branch is behind the remote, then by default it will fast-forward the current branch to match the remote. If the current branch and the remote have diverged, the user needs to specify how to reconcile the divergent branches with --rebase or --no-rebase.

`git push` Updates remote refs using local refs, while sending objects necessary to complete the given refs.

`git stash` Use git stash when you want to record the current state of the working directory and the index, but want to go back to a clean working directory. The command saves your local modifications away and reverts the working directory to match the HEAD commit.

`git stash pop` Remove a single stashed state from the stash list and apply it on top of the current working tree state

`git log` Shows the commit logs.



## 3 What is the basic steps to init a git repo in your local?
### Ans:
1. Create a dir for the repo
2. cd the dir
3. run `git init`
4. commit changes
5. run `git add .`
6. run `git commit`

## 4 How to clone a repo from Github?
### Ans:
1. use git command `git clone repoURL.git`
2. OR open with GitHub Desktop

## 5 How to create a new branch and checkout to that branch?
### Ans:
1. Use `git branch branch_name` to create a new branch
2. Use `git checkout branch_name` to checkout to that branch
3. You can also combine these two commands with `git checkout -b branch_name`

## 6 How to merge the branch test to master branch in command? Show me the commands
### Ans:
1. `git checkout master`
2. `git pull origin master`
3. `git merge test`
4. `git push origin master`

## 7 How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way
### Ans:
1. For git commands, before leaving the branch, run `git stash`
2. when you checkout back to the branch, run `git stach pop`
3. For intelliJ, check the toolbar and goto `VCS` -> `Git` -> `stash changes`
4. When you want to pop your stash, goto `VCS` -> `Git` -> `unstash changes`

## 8 How do you understand PR is based on Branch?
### Ans:
Pull requests let you tell others about changes you've pushed to a branch in a repository on GitHub. Once a pull request is opened, you can discuss and review the potential changes with collaborators and add follow-up commits before your changes are merged into the base branch.
So basically the PR is an operation about merging branches. Therefore, it's based on branch.

## 9 What is maven role ? what it be used to do
### Ans:
Maven is a popular tool for java developers to manage the dependencies and building. The `pom.xml` file is the key to maven's functionalities.

## 10 What is the lifecycle of maven? could you tell me the detail
### Ans:
1. `Validate`: This step validates if the project structure is correct. It checks all the dependencies to make sure they're downloaded and available.
2. `Compile`: compile the source code and convert java files to class files.
3. `Test`: run unit testing
4. `Package`: package the compiled code in JAR
5. `Integration Test`: run the integration testing
6. `Verify`: run checks to verify that the project is valid and meets quality standards
7. `Install`: installs the packaged code to local maven repo
8. `Deploy`: copy the packaged code to remote repo to share it with other developers

## 11 what is the difference between package and install in maven lifecycle 
### Ans:
1. `mvn package` – take the compiled code and package it in its distributable format, such as a JAR
2. `mvn install` – install the package into the local repository, for use as a dependency in other projects locally
3. The main difference between the `mvn package` and `mvn install` commands is that `mvn package` command will compile the source and will package it in its distributable formats, such as a JAR or WAR. The `mvn install` command, however, additionally to compiling the source code and packaging it into a JAR or a WAR, it will also install the package into the local repository, for use as a dependency in other projects locally.

## 12 What is plugins in maven, list some plugin
### Ans:
`maven-gpg-plugin`
`maven-javadoc-plugin`
`maven-compiler-plugin`
`maven-dependency-plugin`
`maven-source-plugin`
`maven-shade-plugin`

## 13 In chuwa0403, create a MavenProject directory, then create a maven Module using Intellij, named it as belows:
1.  groupID: com.chuwa.learn
2.  artifactID: java-core
### Ans:
please check MavenProject dir

## 14 Do Code Review: Go over at least 3 PRs in your repo, tried to leave some useful or useful comments in other students' PR, please don't merge it
### Ans:
