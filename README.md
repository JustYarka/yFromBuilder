# Description
A simple API for creating and handling forms
# Build
```bash
git clone https://github.com/YarkaDev/yFormBuilder
cd yFormBuilder
mvn package
```
# Examples
## SimpleForm
```java
SimpleForm form = SimpleFormBuilder.create("title")
.addText("Hello world!")
.addButton(new ElementButton("Button"))
.addHandler((viewer, formResponse) -> {
    if(formResponse != null) viewer.sendMessage("Clicked...");
}).build();
player.showFormWindow(form);
```
## ModalForm
```java
ModalForm form = ModalFormBuilder.create("title")
.addText("Hello world!")
.addTrueButton("Enter")
.addFalseButton("Back")
.addHandler((viewer, formResponse) -> {
    if(formResponse != null) viewer.sendMessage(formResponse.getClickedButtonId() == 0 ? "false" : "true");
}).build();
player.showFormWindow(form);
```
## CustomForm
```java
CustomForm form = CustomFormBuilder.create("title")
.addLabel("Let`s talk any more about you...")
.addInput(new ElementInput("", "Enter your nickname"))
.addHandler((viewer, formResponse) -> {
    if(formResponse != null) viewer.sendMessage("Your name: " + String.valueOf(formResponse.getResponse(1)));
}).build();
player.showFormWindow(form);
```