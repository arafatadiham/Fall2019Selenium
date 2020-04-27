package com.automation.officeHours;

public class ClassNote_Git_April15 {

    /*

git - version control
1. install Git and check the version on terminal
        git --version
2. Clone the project
        - open git bash in the directory where you want to save your project
        - git clone githubURL
3. Open the project in InteiJ
4. Create your own branch in Github - feature/Mira
5. Create your own branch in your local machine
    - go to terminal in InteliJ
        - git branch feature/Mira
        note: make sure the name of your local and remote repository is the same
6. Switch to our branch
        - git checkout feature/Mira
7. Check that you are in correct branch
        - git branch
8. You did some changes in the code
9. You need to add (if you created new files)
        - git add (name of the file.extention)
        - git add . (add all files)
        - git add .java (add all unstaged java classes)
        - git add src/ (add all files under src folder)
        or during the time you created the file you answer yes on question
            (do you want  to add to git?)
10. Commit your changes - saving on local machine
        1. use terminal
                - git status  (I will see what files have been modified/added - what files are staged(added) for commit)
                - git commit -m"your message here"
        2. IntelliJ UI
            - right click on project name -> git -> commit directory
             review your changes -> add commit message -> click commit
11. !!!! ALWAYS PULL BEFORE YOU PUSH
        - git pull origin master
                    origin branchname - will tell which remote branch you want to pull from
12. If you have a conflict
        1. - resolve conflict
            right click on project name -> git -> resolve conflicts
            (3 pages next to each other)
        2. !!!! Commit your changes again
        3. git pull origin master again - most of times you will see 'already up to date'
13. Push you changes
        - git push origin feature/Mira
14. Create a PUll request (PR) -> will go for a code review and once approved changes will merge into master branch


     */
}
