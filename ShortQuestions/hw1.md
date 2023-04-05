# 2. practice git using the platform. list the git commands you learned
- `git init` Init repo.
- `git add` Add files to the staging area.
- `git commit` Adds the staging area contents to the repository.
- `git status` View the current status of the repository, showing files that have changed.
- `git diff` Compare the difference between files, that is, the difference between the temporary storage area and the work area.
- `git reset` Fallback version.
- `git rm` Delete files from staging and workspace.
- `git mv` Move or rename workspace files.
- `git pull` Download remote code and merge.
- `git push` Upload remote code and merge.
- `git branch <name>` Create branch. 
- `git checkout <name>` Switch the branch.
- `git merge` Merge branch.
- `git rebase` Change the base of the branch.
- `git clone` Copy the project from an existing Git repository.
# 3. What is the basic steps to init a git repo in you local ?
Use commands below:
```
mkdir your_work_dir
cd your_work_dir
git init	
```
# 4. How to clone a repo from Github ?
```
cd your_work_dir
git clone <url>
```
# 5. How to create a new branch and checkout to that branch ?
```
git branch branch_name
git checkout brach_name
```
# 6. How to merge the branch_test to master branch in command ? show me the commands.
```
git checkout -b branch_test
git add .
git commit -m "commit_message"
git checkout main
git merge branch_test
```
# 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you
checkout back to **branch_learn_stash ? try commands way and intellij way.
```
git stash
git stash pop
```
# 8. How do you understand PR is based on Branch?
The purpose of creating different branches is to keep everyone's code separate in collaborative programming, so that when it needs to be uploaded with PR, it is easy to review and avoid affecting the operation of the entire project.
# 9. What is maven role ? what it be used to do ?
The roles of maven are managing dependencies, build project, documentation, reporting and so on. In Java development, maven is a powerful tool. Its essence is a project development tool, which abstracts the project development and management process into a project object model, which is helpful for standardized project management.
# 10. What is the lifecycle of maven? could you tell me the details?
The Maven build lifecycle defines the process of building and publishing a project. It mainly consists of 6 phases: validate, test, package, verify, install, and deploy. Maven has three standard lifecycles. They are clean, default (or build), and site.
- Clean Lifecycle: The clean lifecycle is responsible for cleaning the project by deleting any files generated during the previous build, such as compiled classes, JAR files, and other artifacts.
- Default Lifecycle: The default lifecycle is responsible for building, testing, and packaging the project.
- Site Lifecycle: The site lifecycle is responsible for generating a website for the project, including documentation, reports, and other useful information.
# 11. what is the difference between package and install in maven lifecycle ?
These are two different phases. The package phase is responsible for obtaining compiled code and packaging them into jar or war files. The install phase is responsible for installing the generated tools into the local maven repository and letting other projects use it.
# 12. What is plugins in maven, list some plugins.
The phases of maven's lifecycle are bound to the maven plugins to accomplish specific component tasks. Plugins are separate components in maven.
Plugins:
```
maven-compiler-plugin
maven-dependency-plugin
maven-jar-plugin
maven-antrun-plugin
wagon-maven-plugin
tomcat7-maven-plugin
maven-shade-plugin
maven-source-plugin
maven-assembly-plugin
```









