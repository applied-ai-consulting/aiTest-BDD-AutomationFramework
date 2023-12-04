# How to Merge Automation Code in aiTest Base Framework?

title: How to Merge Automation Code in aiTest Base Framework?
description: Import an auto generated code inside the base framework in respective folders such as .feature file will come under feature folder,
 Pages.java come under PageObjects package, step definitions come under stepDefs package.
type: How-to
categories:
  - How-To
sidebar:
  - {id: what-is-aitest-base-framework, text: "What is aiTest Base Framework?"}
  - {id: how-to-merge-automation-code-in-aitest-base-framework, text: "How to Merge Automation Code in aiTest Base Framework?"}
---

## What is aiTest Base Framework?
1. aiTest base Framework is built on BDD tool that allows you to write feature files in a human-readable format with help of java selenium and maven.
2. Where **Java** is a programming language in this framework, **Selenium** is a web automation tool which interacts with web browsers and **Maven** it helps manage project dependencies, build processes, and the overall project structure.

## Requirements 
1. Cucumber plugin
2. [Java(JDK)](https://www.oracle.com/in/java/technologies/downloads/)
3. [Maven](https://mvnrepository.com/)
  
## How to Merge Automation Code in aiTest Base Framework?
1. Once the Automation Code is generated, the user can download a zip file by clicking on the zip file image.
2. Clone the base framework using this given url [Base Framework](https://github.com/applied-ai-consulting/aiTest_AutomationFramework.git)
3. Need to have ``` Intellij IDE/VS code/Eclipse IDE ``` to import an auto generated code inside the base framework in respective folders such as .feature file will come under feature folder, Pages.java come under PageObjects package,step definitions come under stepDefs package. Unzip the generated automation code.
4. Steps to add files in framework.                                                                                              
i) Add Page Objects java files under  ``` src/test/java>PageObjects ``` package.                                                 
a) Copy the ``` .java file ``` which is under the ``` PageObjects folder ``` which is generated using  Automation Co-pilot.
b) Right click on the ``` PageObjects ``` package and paste the java files which are generated using Automation Co-pilot.
 ![pageobjectsfile](../../images/page-objects-file.png)
ii) Add step definition file under ``` src/test/java>StepDefs ``` package.                                                       
a) Copy the ``` .java file ``` which is under ``` StepDefs folder ``` which is generated using  Automation Co-pilot.
 ![stepdefsfile](../../images/stepdefs-file.png)
b) Right click on the ``` StepDefs ``` package and paste the java files which is generated using Automation Co-pilot.
 ![stepdeffile](../../images/stepdef-file.png)
iii) Add the ``` .feature file ``` under the ``` src/test/Resources/features ``` folder.                                         
a) Copy the ``` .feature file ``` which is under ``` features folder ``` which is generated using Automation Co-pilot.
 ![featurefile](../../images/feature-file.png)
b) Right click on the ``` Feature folder ``` and paste the java files which is generated using Automation Co-pilot.
 ![featurefolderfile](../../images/feature-folder-file.png)

## Run Command
 * ```mvn test ``` This will execute all scenarios from all features using terminal 
 * ``` mvn test -Dcucumber.options="--tags @TagName" ``` This command is used to run scenarios according to Tags defined for scenarios

## Questions answered
- What is aiTest Base Framework? 
- How to use aiTest Base Framework?


