## 1. See `README.md` in `chuwa0403/ShortQuestions`

## 2. practice git using the platform. list the git commands you learned
   
   `git status`: Show the status of your local repository and any uncommitted changes.
   `git init`: Initialize a new Git repository in the current directory.
   `git clone`: Clone a repository from a remote server to your local machine.
   `git add`: Stage changes in your local repository for the next commit.
   `git commit`: Create a new commit with the changes you have staged.
   `git push`: Push your local commits to a remote repository.
   `git pull`: Fetch and merge changes from a remote repository to your local repository.
   `git branch`: List, create, or delete branches in your local repository.
   `git checkout`: Switch to a different branch or version of your code.
   `git merge`: Merge changes from one branch into another.
   `git remote`: List or manage remote repositories.
   `git fetch`: Fetch changes from a remote repository without merging them.

## 3. What is the basic steps to init a git repo in you local?
   
   1. Open the terminal on your machine.
   2. Navigate to the directory where you want to create the Git repository.
   3. Use `git init` command, this will create a new Git repository in the current directory.
   4. You can now start adding files to the repository and committing changes using the git add and git commit commands.

## 4. How to clone a repo from Github?
   
   1. Open the GitHub website and navigate to the repository you want to clone.
   2. Click the "Code" button, and copy the repository's URL to your clipboard
   3. Open the terminal on your local machine, and navigate to the directory where you want to clone the repository using the cd command.
   4. Use git clone followed by the URL you copied in step 3.

## 5. How to create a new branch and checkout to that branch?
   
   1. Open the terminal and navigate to the Git repository where you want to create a new branch.
   2. Use `git branch XXX` command, and replace XXX with the name of the new branch you want to create
   3. Once the branch has been created, you need to checkout to that branch. Use`git checkout XXX` command, and replace XXX with the name of the new branch you just created
   Or, you can combine the above two steps into a single command: `git checkout -b XXX`

## 6. How to merge the branch_test to master branch in command ? show me the commands
   
   `git branch master` (switch to the master branch)
   `git pull origin master` (pull the latest changes from the master branch)
   `git merge branch_test` (Merge the branch_test branch into the master branch)
   And resolve any conflicts that arise during the merge process
   `git commit -m "merge branch_test to master"` (commit the changes)
   `git push origin master` (push the changes to the remote master branch)

## 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you 
## checkout back to **branch_learn_stash ? try commands way and intellij way.

   Commands Way:
   `git stash` (stash your changes)
   `git checkout XXX` (checkout to a different branch)
   do some work in the other branch
   `git checkout branch_learn_stash` (checkout back to branch_learn_stash)
   `git stash pop` (pop the stash to apply the changes you stashed earlier)

   Intellij way:
   You can also use the "Git Stash" action in the "Git" menu to stash and pop changes.

## 8. How do you understand PR is based on Branch?
   
   When you create a new branch in your Git repository and make changes to the files in that branch, you can create a Pull Request to propose merging those changes into another branch.
   The PR will typically have a source branch and a target branch. The source branch is the branch that contains the changes you want to merge, and the target branch is the branch into which you want to merge the changes. In general, if a PR is based on a branch, this means that the changes being proposed for merge are contained within that branch, and the branch serves as the basis for the changes in the PR. The PR can then be reviewed and approved or rejected, and if approved, the changes will be merged into the target branch.

## 9. What is maven role ? what it be used to do ?
   
   Maven is a build automation tool primarily used for Java projects. Its main role is to manage the build process of a project, including compilation, testing, packaging, and deployment. It provides a declarative way to describe the project structure, dependencies, and build process, which makes it easier to maintain and reproduce the build process across different environments.

   Maven can be used to do the following things:
   Dependency management: Maven can automatically download and manage dependencies required by a project from repositories such as Maven Central.
   Build automation: Maven can automate the build process of a project, including compiling the source code, running tests, generating documentation, and packaging the project into a distributable format such as a JAR or WAR file.
   Project structure: Maven provides a standard project structure that can be easily maintained and understood by developers and build tools.
   Plugins: Maven supports a wide range of plugins that can be used to perform additional tasks such as code quality checks, static analysis, and code coverage.
   Profiles: Maven allows you to define different build profiles that can be used to customize the build process for different environments or configurations.

## 10. What is the lifecycle of maven? could you tell me the details ?
   The Maven build process consists of a series of well-defined phases that are organized into a build lifecycle. There are three built-in lifecycles in Maven: `default`, `clean`, and `site`.

   The `default` lifecycle is the most important and commonly used lifecycle in Maven. It includes the following phases:

   `validate`: Validates the project is correct and all necessary information is available.
   `compile`: Compiles the source code of the project.
   `test`: Runs unit tests for the compiled code.
   `package`: Packages the compiled code into a distributable format, such as a JAR or WAR file.
   `verify`: Runs any checks to verify the package is valid and meets quality criteria.
   `install`: Installs the package into the local repository, so it can be used as a dependency in other projects.
   `deploy`: Copies the final package to the remote repository for sharing with other developers and projects.
   
   The `clean` lifecycle is used to clean the project of any generated files and artifacts from previous builds. It includes the following phases:

   `pre-clean`: Executes tasks before the cleaning process begins.
   `clean`: Removes all files generated by the previous build.
   `post-clean`: Executes tasks after the cleaning process is complete.
   
   The `site` lifecycle is used to generate project documentation and reports. It includes the following phases:
   
   `pre-site`: Executes tasks before generating the documentation and reports.
   `site`: Generates the project documentation and reports.
   `post-site`: Executes tasks after the documentation and reports have been generated.
   `site-deploy`: Deploys the generated documentation and reports to a remote server.
   

## 11. What is the difference between package and install in maven lifecycle ?

   The main difference between the package and install phases in the Maven lifecycle is in where the resulting artifact is stored.

   During the package phase, Maven creates a distributable format of the project (such as a JAR, WAR, or ZIP file) and places it in the target directory of the project. This artifact is intended for local testing and distribution.

   On the other hand, during the install phase, Maven not only creates the distributable format of the project, but also copies it to the local repository. The local repository is a cache of all the project dependencies, as well as any artifacts that have been installed locally. The install phase allows the project to be installed locally so that other projects can use it as a dependency.

   In summary, the package phase creates the artifact in the target directory, while the install phase creates the artifact in the local repository. The package phase is typically used during development and testing, while the install phase is used when the project is ready for distribution or when other projects depend on it.

## 12. What is plugins in maven, list some plugins.
   In Maven, plugins are a key feature that enables the build process to be customized with additional functionality beyond what is provided by the built-in build phases. Plugins can be used to perform a wide range of tasks, such as compiling source code, running tests, packaging the project, deploying to a server, generating reports, and many more.

   Plugins:
   `maven-compiler-plugin`: Compiles Java source code into bytecode.
   `maven-surefire-plugin`: Runs JUnit or TestNG tests during the test phase.
   `maven-jar-plugin`: Packages the compiled code into a JAR file.
   `maven-war-plugin`: Packages the compiled code into a WAR file for deployment to a web server.
   `maven-install-plugin`: Installs the project artifacts into the local repository.
   `maven-deploy-plugin`: Deploys the project artifacts to a remote repository or server.
   `maven-release-plugin`: Automates the process of releasing a new version of the project.
   







