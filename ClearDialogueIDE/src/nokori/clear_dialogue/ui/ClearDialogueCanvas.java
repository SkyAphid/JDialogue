package nokori.clear_dialogue.ui;

import nokori.clear.vg.widget.assembly.DraggableWidgetAssembly;
import nokori.clear_dialogue.project.DialogueResponse;
import nokori.clear_dialogue.project.DialogueText;
import nokori.clear_dialogue.project.Project;
import nokori.clear_dialogue.ui.widget.node.DraggableDialogueResponseWidget;
import nokori.clear_dialogue.ui.widget.node.DraggableDialogueTextWidget;
import nokori.clear_dialogue.ui.widget.node.DraggableDialogueWidget;

public class ClearDialogueCanvas extends DraggableWidgetAssembly {
	
	private SharedResources sharedResources;
	
	public ClearDialogueCanvas(SharedResources sharedResources) {
		super();
		this.sharedResources = sharedResources;
	}
	
	public void addDialogueTextNode() {
		Project project = sharedResources.getProject();

		DialogueText dialogue = new DialogueText(project, "New Dialogue " + project.getNumDialogue(), "", getNewDialogueX(), getNewDialogueY());
		
		DraggableDialogueTextWidget widget = new DraggableDialogueTextWidget(sharedResources, dialogue);
		
		addChild(widget);
	}
	
	public void addDialogueResponseNode() {
		Project project = sharedResources.getProject();
		
		DialogueResponse dialogue = new DialogueResponse(project, "New Response " + project.getNumDialogue(), "", getNewDialogueX(), getNewDialogueY());
		
		DraggableDialogueResponseWidget widget = new DraggableDialogueResponseWidget(sharedResources, dialogue);
		
		addChild(widget);
	}
	
	public void deleteDialogueNode(DraggableDialogueWidget widget) {
		sharedResources.getProject().removeDialogue(widget.getDialogue());
		removeChild(widget);
	}
	
	private float getNewDialogueX() {
		return parent.getWidth()/2 - DraggableDialogueWidget.DEFAULT_MODE.getWidth()/2;
	}
	
	private float getNewDialogueY() {
		return parent.getHeight()/2 - DraggableDialogueWidget.DEFAULT_MODE.getHeight()/2;
	}
}