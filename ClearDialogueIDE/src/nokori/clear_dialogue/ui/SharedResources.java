package nokori.clear_dialogue.ui;

import java.io.IOException;

import nokori.clear.vg.NanoVGContext;
import nokori.clear.vg.font.Font;
import nokori.clear_dialogue.project.Project;

/**
 * This is a pass-around class that allows JDialogue to communicate data around the program, such as the current project, context hints, etc.
 */
public class SharedResources {
	private String contextHint;
	
	private Project project = new Project();
	
	private Font notoSans, notoSerif;
	
	public void init(NanoVGContext context) {
		try {
			notoSans = new Font("res/fonts/NotoSans/", "NotoSans-Regular", "NotoSans-Bold", "NotoSans-Italic", "NotoSans-Light").load(context);
			notoSerif = new Font("res/fonts/NotoSerif/", "NotoSerif-Regular", "NotoSerif-Bold", "NotoSerif-Italic", "NotoSerif-Light").load(context);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the current context hint visible at the bottom of the screen. Context hints give contextual information on how to use the IDE.
	 * @return
	 */
	public String getContextHint() {
		return contextHint;
	}

	/**
	 * Sets the current context hint.
	 * @param contextHint
	 */
	public void setContextHint(String contextHint) {
		this.contextHint = contextHint;
	}
	
	/**
	 * Resets the context hint back to the general controls for navigating the canvas.
	 */
	public void resetContextHint() {
		contextHint = "Drag LMB = Pan Canvas | RMB = Context Menu";
	}

	/**
	 * Gets the currently active JDialogue Project.
	 * @return
	 */
	public Project getProject() {
		return project;
	}
	
	/**
	 * Sets a new JDialogue Project and refreshes the Canvas with its data.
	 * @param project
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	public Font getNotoSans() {
		return notoSans;
	}

	public Font getNotoSerif() {
		return notoSerif;
	}
}