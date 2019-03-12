package _005_SWTMultiShells;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MultiShells {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
//		Display display = Display.getDefault();
		Display display = new Display();
		
		final Shell parent = new Shell(display,SWT.SHELL_TRIM);
		parent.setText("�ര��ʵ��");
        parent.setSize(450, 300);
        
        Button addShell = new Button(parent,SWT.CENTER);
        addShell.setText("�����Ӵ���");
        //ע��Button�ĵ���¼�
        addShell.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				createChildShell(parent,"�Ӵ���");
			}
        	
		}) ;
        addShell.pack();
        
		parent.open();
		parent.layout();
		while (!parent.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	protected static Shell createChildShell(Shell parent, String childrenName) {
		Shell shell = new Shell(parent,SWT.DIALOG_TRIM);
		shell.setText(childrenName);
		shell.setSize(100,100);
		shell.open();
		return shell;
		
	}

}
