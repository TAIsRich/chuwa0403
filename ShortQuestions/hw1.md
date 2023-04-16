# Learn MarkDown and show all of basic usage in the ShortQuestions/README.md
See ```ShortQuestions/README.md```

# Practice git using the platform. list the git commands you learned
* ```git init``` Initializes a new repo 
* ```git clone``` Clone a repo
* ```git add``` Add changes to the index
* ```git commit``` Commit changes to the repo
* ```git status``` Show the status of repo
* ```git branch``` List current branch
* ```git checkout``` Change to another branch
* ```git merge``` Merge other branch into the current branch
* ```git push``` Push to remote repo
* ```git pull``` Pull changes from remote repo
* ```git help``` Get help
* ```git stash```Hide the change on current branch

# What is the basic steps to init a git repo in you local ?
1. ```cd repo```
2. ```git init```
3. ```git add .```
4. ```git commit -m "msg```
5. ```git push --set-upstream origin <branch name>```

# How to clone a repo from Github ?
1. ```cd repo```
2. ```git clone <url>```

# How to create a new branch and checkout to that branch ?
1. ```git branch <new-branch>```
2. ```git checkout <new-branch>```

# How to merge the branch_test to master branch in command ? show me the commands
1. ```git checkout master```
2. ```git merge branch_test```
3. ```git commit -m "merge branch_test into master"```
4. ```git push```

# How to stash your new code before leaving branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.

### Command Line
1. ```git stash save "msg"```
2. ```git stash pop```

### IntelliJ
1. Git -> Uncommitted changes -> Stash Changes.
2. Git  -> Uncommitted changes -> Unstash Changes.

# How do you understand PR is based on Branch?
When you submitted the code and request other team members to review it before merge into the master, you can create a pull request(PR)

# What is maven role ? what it be used to do ?
Maven is a auto build tool for Java applications. It can manage the dependencies, building, testing and packaging of Java softwares. We can define the dependencies in
pom.xml file.

# What is the lifecycle of maven? could you tell me the details ?
The maven builds lifecycle is the tasks performed when the maven build commands are executed.
1. **Validate**: Check if the project is valid, structure is correct, dependencies are available
2. **Compile**: Compile Java source code into bytecode
3. **Test**: Run unit tests for the code
4. **Package**: Package the code into JAR or WAR file
5. **Verify**: Ensure the package is correct
6. **Install**: Install the package into local repo
7. **Deploy**: Deploy the package to remote repo or server.

# What is the difference between package and install in maven lifecycle ?

* maven package: Compile and package the code into JAR or WAR file.
  
* maven install: Also install the package in the local repo(~/.m2)
    ```shell
    [INFO] --- maven-install-plugin:2.4:install (default-install) @ java-core ---
    [INFO] Installing /Users/cirun/Desktop/Code/chuwa0403/MavenProject/TestMavenModule/target/java-core-1.0-SNAPSHOT.jar to /Users/cirun/.m2/repository/com/chuwa/learn/java-core/1.0-SNAPSHOT/java-core-1.0-SNAPSHOT.jar
    [INFO] Installing /Users/cirun/Desktop/Code/chuwa0403/MavenProject/TestMavenModule/pom.xml to /Users/cirun/.m2/repository/com/chuwa/learn/java-core/1.0-SNAPSHOT/java-core-1.0-SNAPSHOT.pom
    ```

# What is plugins in maven, list some plugins
A maven plugin is a collection of commands that can be executed during the build process.
* maven-compiler-plugin
* maven-surefire-plugin
* maven-assembly-plugin
* maven-dependency-plugin
* maven-jar-plugin
* maven-war-plugin
* maven-deploy-plugin
* maven-resource-plugin
* spring-boot-maven-plugin

# In chuwa0403, create a MavenProject directory, then create a maven Module using Intellij
See ```../MavenProhect/TestMavenModule```

# Do Code Review: Go over at least 3 PRs in your repo, tried to leave some useful or useful comments in other students' PR, please don't merge it