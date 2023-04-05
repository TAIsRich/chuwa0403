# Q1. LearnMarkDownandshowallofbasicusageintheShortQuestions/README.md
Did in shortQuestions/README.md

# Q2. [practice git using the platform.list the git commands you learned using this link](https://learngitbranching.js.org/)
## Basic Git commands
+ `git init` initializes a brand new Git repository and begins tracking an existing directory. It adds a hidden subfolder within the existing directory that houses the internal data structure required for version control.
+ `git colne` creates a local copy of a project that already exists remotely. The clone includes all the project's files, history, and branches.
+ `git add` stages a change. Git tracks changes to a developer's codebase, but it's necessary to stage and take a snapshot of the changes to include them in the project's history. This command performs staging, the first part of that two-step process. Any changes that are staged will become a part of the next snapshot and a part of the project's history. Staging and committing separately gives developers complete control over the history of their project without changing how they code and work.
+ `git commit` saves the snapshot to the project history and completes the change-tracking process. In short, a commit functions like taking a photo. Anything that's been staged with `git add` will become a part of the snapshot with git commit.
+ `git status` shows the status of changes as untracked, modified, or staged.
+ `git branch` shows the branches being worked on locally.
+ `git merge`  merges lines of development together. This command is typically used to combine changes made on two distinct branches. For example, a developer would merge when they want to combine changes from a feature branch into the main branch for deployment.
+ `git pull` updates the local line of development with updates from its remote counterpart. Developers use this command if a teammate has made commits to a branch on a remote, and they would like to reflect those changes in their local environment.
+ `git push` updates the remote repository with any commits made locally to a branch.

## Example: Contribute to an existing repository
```
# download a repository on GitHub to our machine
# Replace `owner/repo` with the owner and name of the repository to clone
git clone https://github.com/owner/repo.git

# change into the `repo` directory
cd repo

# create a new branch to store any new changes
git branch my-branch

# switch to that branch (line of development)
git checkout my-branch

# make changes, for example, edit `file1.md` and `file2.md` using the text editor

# stage the changed files
git add file1.md file2.md

# take a snapshot of the staging area (anything that's been added)
git commit -m "my snapshot"

# push changes to github
git push --set-upstream origin my-branch
```

## Example: Start a new repository and publish it to GitHub
```
# create a new directory, and initialize it with git-specific functions
git init my-repo

# change into the `my-repo` directory
cd my-repo

# create the first file in the project
touch README.md

# git isn't aware of the file, stage it
git add README.md

# take a snapshot of the staging area
git commit -m "add README to initial commit"

# provide the path for the repository you created on github
git remote add origin https://github.com/YOUR-USERNAME/YOUR-REPOSITORY-NAME.git

# push changes to github
git push --set-upstream origin main
```

## Example: contribute to an existing branch on GitHub
```
# change into the `repo` directory
cd repo

# update all remote tracking branches, and the currently checked out branch
git pull

# change into the existing branch called `feature-a`
git checkout feature-a

# make changes, for example, edit `file1.md` using the text editor

# stage the changed file
git add file1.md

# take a snapshot of the staging area
git commit -m "edit file1"

# push changes to github
git push
```

[More information](https://git-scm.com/docs)

# Q3. What is the basic steps to init a git repo in you local?
1. Open your command line interface (CLI) or terminal and navigate to the directory where you want to initialize your git repository.
2. `git init`
4. Add files using the command `git add .` (to add all files) or `git add` <filename> (to add specific files).
5. Commit using the command `git commit -m "<commit message>"`.
6. Push your changes to a remote repository using the command `git push <remote> <branch>`. For example, `git push origin main`.

# 4. How to clonea repo from Github?
2. Copy the URL provided.
3. Go to the directory where you want to clone the repository.
4. Type the command git clone <repository URL> and press enter. For example, `git clone https://github.com/username/repository.git`.
6. Once the cloning process is complete, you can make changes to the files on your local machine and then push those changes back to the remote repository using the `git push `command. You can also pull changes from the remote repository to your local machine using the `git pull` command.

# 5. How to create a new branch and checkout to that branch?
1. Go to the local repository where you want to create a new branch.
2. Type the command `git branch <branch-name>` and press enter. This will create a new branch with the given name, but you will still be on the current branch.
3. To switch to the new branch, type the command `git checkout <branch-name> `and press enter. This will switch your local repository to the new branch and you can start making changes on this new branch.
4. Alternatively, you can use the shorthand command `git checkout -b <branch-name> `to create a new branch and switch to it in one command.

# 6. How to merge the branch_test to master branch in command? show me the commands
```
cd /path/to/repository
git checkout master
git merge branch_test
git push origin master
```
# 7. How to stash your new code before leaving branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.
```
cd /path/to/repository
git checkout branch_learn_stash
git stash save "Stash message"
git checkout other-branch
git checkout branch_learn_stash
git stash pop
```

# 8. How do you understand PR is based on Branch?
A Pull Request (PR) is a feature in Git that allows developers to propose changes to a codebase and request that those changes be merged into a branch. 
A Pull Request is usually based on a branch, which contains the changes to be merged.

# 9. What is maven role?what it be used to do?
Maven is a management tool for Java projects. Its primary role is to simplify the build process for Java applications by automating many of the repetitive tasks involved in building, testing, and packaging applications.

Maven provides a standard way to manage project dependencies, allowing developers to easily specify the external libraries that their project requires, and Maven takes care of downloading and including these libraries in the project's classpath.

Maven also provides a standardized project structure and build lifecycle, which makes it easier for developers to understand and contribute to projects. Maven uses a project object model (POM) file to describe the project's dependencies, build process, and other metadata.

Some of the things that Maven can be used to do include:
```
1. Downloading and managing project dependencies.
2. Building and packaging Java applications.
3. Running unit tests and generating reports.
4. Generating documentation for the project.
5. Deploying artifacts to a remote repository.
6. Managing project versions and releases.
```

Overall, Maven provides **a powerful and flexible build system for Java projects** that can greatly simplify the development process, reduce errors, and improve productivity.

# 10. What is the lifecycle of maven? could you tell me the details ?
Maven has a defined build lifecycle that is composed of a sequence of phases. A build lifecycle is the sequence of build phases(a project goes through in order to build a distributable package, such as a JAR file, WAR file, or an executable file).

Here are the 3 build lifecycles in Maven:

1. Clean Lifecycle: This lifecycle handles project cleaning,which contains a single phase: clean. It removes all files generated by the previous build, preparing the project for a new build. 

2. Default Lifecycle: This is the most important lifecycle, which handles building and deploying the project. It consists of a series of phases, including:
   - Validate: validate the project, check if all dependencies are available and the settings are correct.
   - Compile: compile the source code of the project.
   - Test: test the compiled source code using a suitable unit testing framework. 
   - Package: package the compiled code into a distributable format, such as a JAR or WAR file. 
   - Verify: run any checks to verify that the package is valid and meets the quality criteria.
   - Install: install the package into the local repository, making it available for other projects that depend on it.
   - Deploy: deploy the package to a remote repository or server.


3. Site Lifecycle: This lifecycle handles the creation of the project's site documentation. It consists of a series of phases, including:
 - Site: generate the project's site documentation.
 - Site-deploy: deploy the site documentation to a remote repository or server.

# 11. what is the difference between package and install in maven lifecycle ?
In Maven, package and install are two different phases of the default build lifecycle that serve different purposes.

The **package phase** is responsible for creating a distributable package of the project's compiled code. This phase takes the compiled code from the compile and test phases and packages it into a format such as a JAR or WAR file. The packaged file is typically stored in the target directory of the project.

On the other hand, the **install** phase is responsible for installing the packaged project artifact into the local Maven repository. This phase takes the packaged file from the package phase and installs it into the local Maven repository, making it available for other projects to use as a dependency.

The main difference between package and install is that package **only creates the packaged artifact**, while install **creates the packaged artifact and installs it into the local Maven repository**. The install phase is typically run after the package phase, and it is required for other projects to use the packaged artifact as a dependency.

# 12. What is plugins in maven, list some plugins.
+ Maven Compiler Plugin: Compiles the source code of the project.

+ Maven Surefire Plugin: Runs the project's unit tests.

+ Maven Jar Plugin: Builds a JAR file from the project's compiled classes.

+ Maven War Plugin: Builds a WAR file from the project's compiled classes, web content, and dependencies.

+ Maven Assembly Plugin: Creates an assembly of an application, including its dependencies and resources.

+ Maven Clean Plugin: Cleans the project's build directory.

+ Maven Install Plugin: Installs the project's artifacts into the local Maven repository.

+ Maven Deploy Plugin: Deploys the project's artifacts to a remote repository or server.

+ Maven Shade Plugin: Creates a shaded JAR file, which includes all the project's dependencies in a single JAR file.

+ Maven Checkstyle Plugin: Checks the project's code against a set of coding standards.


# 13 & 14
Already created Maven project and command in other students' PR
