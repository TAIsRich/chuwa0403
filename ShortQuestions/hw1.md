# HW1

---

## 1. Learn Mark Down

----

See `README.md` in `chuwa0403/ShortQuestions`

## 2. Practice Git

---

- `git init` initializes a brand new Git repository and begins tracking an existing directory. It adds a **hidden subfolder** within the existing directory that houses the internal data structure required for version control.
- `git clone` creates a local copy of a project that already exists remotely. The clone includes all the project's files, history, and branches.
- `git add` stages a change. Git tracks changes to a developer's codebase, but it's necessary to stage and take a snapshot of the changes to include them in the project's history. This command performs staging, the first part of that two-step process. Any changes that are staged will become a part of the next snapshot and a part of the project's history. Staging and committing separately gives developers complete control over the history of their project without changing how they code and work.
- `git commit` saves the snapshot to the project history and completes the change-tracking process. In short, a commit functions like taking a photo. Anything that's been staged with `git add` will become a part of the snapshot with `git commit`.
- `git status` shows the status of changes as untracked, modified, or staged.
- `git branch` shows the branches being worked on locally.
- `git merge` merges lines of development together. This command is typically used to combine changes made on two distinct branches. For example, a developer would merge when they want to combine changes from a feature branch into the main branch for deployment.
- `git pull` updates the local line of development with updates from its remote counterpart. Developers use this command if a teammate has made commits to a branch on a remote, and they would like to reflect those changes in their local environment.
- `git push` updates the remote repository with any commits made locally to a branch.

### Example: Contribute to an existing repository

```bash
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

### Example: Start a new repository and publish it to GitHub

First, you will need to create a new repository on GitHub. For more information, see "[Hello World](https://docs.github.com/en/get-started/quickstart/hello-world)." **Do not** initialize the repository with a README, .gitignore or License file. This empty repository will await your code.

```bash
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

### Example: contribute to an existing branch on GitHub

This example assumes that you already have a project called `repo` on the machine and that a new branch has been pushed to GitHub since the last time changes were made locally.

```bash
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



## 3. How to init a git repo in your local

---

1. Open terminal or command prompt.
2. Using `cd` navigate to the working directory.
3. Type `git init` to initialize a git repository.
4. This working directory is now a git repository.

```bash
# Navigate to the working directory
cd /work_directory

# Initialize this directory to a git repository
git init
```

## 4. How to clone a repo from Github

---

1. Copy the clone URL (https://github.com/owner/repo.git) from GitHub.
2. Open terminal and `cd` to the local working directory.
3. Using `git clone https://github.com/owner/repo.git` to clone the repository.

```bash
# download a repository on GitHub to our machine
# Replace `owner/repo` with the owner and name of the repository to clone
git clone https://github.com/owner/repo.git

# change into the `repo` directory
cd repo
```

## 5. How to create a new branch and checkout to that branch

---

1. Using `git branch branch_name` to create your own feature branch.
2. Type `git checkout branch_name` to switch to your branch.
3. Alternatively, we can use `git checkout -b branch_name` to create a feature branch and switch to the branch.

```bash
# create a new branch to store any new changes
git branch my-branch

# switch to that branch (line of development)
git checkout my-branch

# create a new branch and switch to this new branch
git checkout -b my-branch
```

## 6. How to merge a branch to master branch in command

---

1. Switch to the main branch first.
2. Run `git merge` to merge the branch_test.
3. Type `git commit -m "..."` To commit the changes.
4. Use `git push origin master` to push the changes to the remote repository.

```bash
# Switch to the master branch
git checkout master

# merger the test_branch to master
git merger branch_test

# commit changes
git commit -m "Merge branch_test into master"

# push changes to the remote repository
git push origin master
```

## 7. How to stash your new code before leaving branch and pop your stash when you checkout back

---

1. Run `git stash save "message"` to save the current stash code to this branch.
2. Switch to another branch to work.
3. Go back to stash branch and type `git stash pop` to recover the stash code we saved.

```bash
# sace current changes
git stash save "Current stash"

# checkout to a different branch to code
git checkout other_branch

# go back to the stash branch after finishing work on other branch
git checkout branch_learn_stash

# pop the stash you created earlier and continue coding
git stash pop
```

## 8. How to understand PR is based on Branch

---

A pull request (PR) is based on a branch because it allows developers to propose changes to a project while keeping those changes separate from the main codebase until they are reviewed and approved.

When a developer wants to make changes to a project, they typically create a new branch from the main branch of the codebase. This new branch contains a copy of the codebase at a specific point in time, and the developer can make changes to the code without affecting the main branch.

Once the developer has made their changes and tested them, they can create a pull request to propose the changes for merging into the main branch. The pull request is essentially a request to merge the changes made in the developer's branch into the main branch. The changes are reviewed by other developers, and if they are approved, they can be merged into the main branch.

Using pull requests and branches helps to keep the main codebase stable and ensures that changes are properly reviewed and tested before they are merged into the main branch. It also allows multiple developers to work on different features or fixes simultaneously without interfering with each other's work.

## 9. What is the role of Maven, what can we do with it

---

1. Manage dependencies(package): Maven allows developers to declare dependencies on external libraries and manage them easily, ensuring that the correct versions of libraries are downloaded and used in the project.
2. Build automation(life cycle): Maven automates the build process of a project by providing a set of predefined build phases, such as compiling source code, packaging code into a distributable format, and running tests.
3. Project Organization: Maven provides a standardized directory structure for organizing project files and resources, making it easier for developers to navigate and understand the project.
4. Documentation: Maven integrates with popular Java IDEs like Eclipse and IntelliJ IDEA, making it easy for developers to work with their projects in their preferred development environment.
5. Reporting: Maven generates reports on various aspects of the project, such as code quality, test coverage, and dependencies, providing developers with valuable insights and feedback.

We can use Maven to manage many dependencies of a project. Maven integrates with poplar Java IDES like Eclipse and IntelliJ, making it easy for developers to work with their projects in their preferred development environment. Maven simplifies the process of building and managing Java projects, reducing the time and effort required for developers to set up and maintain their projects.

## 10. What is the lifecycle of Maven

---

1. clean: Is responsible for cleaning up the build directory by removing all generated files from the previous build. This phase is intended to prepare the project for a fresh build by deleting any artifacts and intermediate files from the previous build that may interfere with the current build.
2. validate: This phase validates the project configuration and checks that all necessary information is available. It can be used to perform some initial checks before starting the build.
3. compile: This phase compiles the source code of the project, producing the class files that are needed for the subsequent phases. It uses the compiler plugin to compile the Java code.
4. test: This phase runs the tests for the project, using the testing framework specified in the project configuration. The results of the tests are reported to the console and can be accessed in the target/surefire-reports directory.
5. package: This phase creates an executable package for the project, such as a JAR, WAR, or EAR file, depending on the project type. The package contains the compiled code, resources, and other necessary files.
6. verify: This phase performs checks on the packaged artifact to ensure its integrity and correctness. It includes tasks such as checking for duplicate classes, verifying that all required dependencies are included, and running additional tests if necessary.
7. install: This phase installs the packaged artifact in the local repository, making it available for other local projects to use as a dependency.
8. site: This phase is responsible for generating a website for the project. This phase generates a set of HTML pages that provide information about the project, such as documentation, test reports, and code metrics.
9. deploy: This phase deploys the packaged artifact to a remote repository or server, making it available for other users and projects to download and use.

## 11. What is the difference between package and install in maven lifecycle

---

The "package" phase is the fourth phase in the default lifecycle, and it is responsible for creating a binary distribution of the project in a specified format, such as a JAR, WAR, or EAR file. This phase generates the artifact and places it in the project's target directory, but it does not install it anywhere. The generated artifact is intended to be used only within the local build environment.

On the other hand, the "install" phase is the seventh phase in the default lifecycle, and it is responsible for installing the artifact in the local Maven repository. This phase copies the generated artifact to the local repository, making it available to other local projects that depend on it. The local repository is a cache of artifacts that can be shared among multiple projects on the same machine, improving build speed and reducing redundant downloads of the same artifact.

To summarize, the "package" phase generates the artifact for the current project and places it in the target directory, while the "install" phase copies the generated artifact to the local Maven repository, making it available for other projects to use. The "package" phase is typically used for local development and testing, while the "install" phase is used when the project is ready for wider distribution and sharing among multiple projects.

## 12. What is plugins in maven, list some plugins

---

Plugins in Maven are a key feature that allows developers to extend the functionality of the build process beyond the standard build lifecycle. A plugin is a collection of one or more goals (i.e., tasks) that can be executed during the build process to perform various actions such as compiling code, running tests, generating documentation, deploying artifacts, and more.

When Maven encounters a plugin during the build process, it will download and install the plugin and its dependencies from a central repository, and then execute the requested goal. Plugins can be configured to run in a variety of different ways, such as running goals in parallel, skipping execution if certain conditions are met, or running a goal multiple times with different configurations.

Overall, plugins in Maven provide a powerful and flexible way to customize and extend the build process, allowing developers to tailor the build process to the specific needs of their project and integrate with a wide range of external tools and services.

List some plugins:

* spring-boot-maven-plugin
* maven-antrun-plugin
* maven-enforcer-plugin
* maven-compiler-plugin

