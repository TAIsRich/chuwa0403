# HW1
## 1. Learn **MarkDown** and show all of basic usage in the **ShortQuestions/README.md**
Please check the [README.md](README.md) file.

## 2. Practice git using the [platform](https://learngitbranching.js.org/), list the git commands you learned.
```
git commit 
git branch <branch_name>
git checkout <branch_name>
# Can be replaced by
git checkout -b <branch_name>
git merge
git rebase # modifies the commit history to make it appear as if the changes were made on a single branch.
git pull 
git push
git fetch
git stash
```

## 3. What is the basic steps to init a git repo in you local?
1. Open the terminal or commend prompt.
2. Navigate to the directory where you want to create the Git repository.
   - You can also right-click the mouse and click `Git Bash Here` to replace the first two steps.
3. Type `git init` command to initialize a new Git repository.

## 4. How to clone a repo from GitHub?
1. Open the terminal or commend prompt.
2. Navigate to the directory where you want to clone the Git repository.
3. Copy the GitHub repository page URL.
4. Type `git clone <repository URL>` command to clone the GitHub repository.

## 5. How to create a new branch and checkout to that branch?
1. Use `git branch <branch_name>` command to create a new branch.
2. Use `git checkout <branch_name>` command to checkout the branch.
3. Or you can use `git checkout -b <branch_name>` to replace the first two steps.

## 6. How to merge the `branch_test` to `master` branch in command?
1. Switch to the `master` branch:
```
git checkout master
```
2. Pull any changes from remote `master` branch:
```
git pull origin master
```
3. Merge the `branch_test` into `master` branch:
```
git merge branch_test
```
4. Commit the changes to the `master` branch:
```
git commit -m "Merge branch_test into master"
```
5. Push the changes to the remote `master` branch:
```
git push origin master
```

## 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to branch_learn_stash ? 
Commands way:
1. Stash your changes:
```
git stash save "Your stash message"
```
2. Switch to a different branch
```
git checkout other_branch
```
3. Do your work on `other_branch`.
4. Go back to the branch_learn_stash branch:
```
git checkout branch_learn_stash
```
5. Retrieve your stash:
```
git stash pop
```
Intellij way:
1. Click `Git` in the toolbar.
2. Click `VCS Operations Popup`.
3. Click `Stash Changes` to stack the code
4. Click `Unstash Changes` to pop your stash.

## 8. How do you understand PR is based on Branch?
The pull request (PR) allows changes made in one branch to be merged into another branch. When you create a pull request, it means you are asking someone to review your code and approve the changes you made. After the review and if there is nothing wrong with your code, they will merge it into the target branch.

## 9. What is maven role? What it is used to do?
- **Dependency Management**: Maven can let you manage dependencies with pom.xml file.
- **Build Management**: Mave can let you build a project easily, and provides a way to describe the structure of a project.
- **Plugin Management**: Maven supports plugins that can be used to extend the functionality of the build process.
- **Reporting**:  Maven can generate reports that provide information about the status of your project, including code quality metrics, test results, and documentation.

## 10. What is the lifecycle of maven? Could you tell me the details?
- Prepare resources: Resource copying can be customized in this phase.
- Validate: Validates if the project is correct and if all necessary information  is available.
- Compile: Source code compilation is done in this phase.
- Test: Tests the compiled source code suitable for testing framework.
- Package: This phase creates the JAR/WAR package as mentioned in the packaging in POM.xml.
- Install: This phase installs the package in local/remote maven repository.
- Deploy: Copies the final package to the remote repository.

## 11. What is the difference between package and install in maven lifecycle?
`package` is to package the compiled code into JAR/WAR package.  
`install` will package the compiled code and also install the package in local/remote maven repository.
## 12. What is plugins in maven, list some plugins.
Plugins in Maven are extensions that provide additional functionality to the build process.
1. `clean`: Clean up after the build.
2. `compiler`: Compiles Java sources.
3. `deploy`: Deploy the built artifact to the remote repository.
4. `failsafe`: Run the JUnit integration tests in an isolated classloader.
5. `install`: Install the built artifact into the local repository.
6. `resources`: Copy the resources to the output directory for including in the JAR.
