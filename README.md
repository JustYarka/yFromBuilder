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
.setHandler((viewer, formResponse) -> {
    viewer.sendMessage("Clicked...");
})
.setCloseHandler((viewer, formResponse) -> {
    viewer.sendMessage("Form closed");
})
.build();
player.showFormWindow(form);
```
## ModalForm
```java
ModalForm form = ModalFormBuilder.create("title")
.addText("Hello world!")
.addTrueButton("Enter")
.addFalseButton("Back")
.setHandler((viewer, formResponse) -> {
    viewer.sendMessage(formResponse.getClickedButtonId() == 0 ? "false" : "true");
})
.setCloseHandler((viewer, formResponse) -> {
    viewer.sendMessage("Form closed");
})
.build();
player.showFormWindow(form);
```
## CustomForm
```java
CustomForm form = CustomFormBuilder.create("title")
.addLabel("Let`s talk any more about you...")
.addInput(new ElementInput("", "Enter your nickname"))
.setHandler((viewer, formResponse) -> {
    viewer.sendMessage("Your name: " + String.valueOf(formResponse.getResponse(1)));
})
.setCloseHandler((viewer, formResponse) -> {
    viewer.sendMessage("Form closed");
})
.build();
player.showFormWindow(form);
```
