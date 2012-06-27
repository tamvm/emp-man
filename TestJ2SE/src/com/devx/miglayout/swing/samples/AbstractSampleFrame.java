/**
 *
 */
package com.devx.miglayout.swing.samples;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JWindow;

/**
 * Ancestor for all sample dialogs
 *
 * @author Jacek Furmankiewicz
 *
 */
public abstract class AbstractSampleFrame extends JInternalFrame {

    public AbstractSampleFrame(String title) {
        super(title, true, true, true, true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        initComponents();
    }

    //override this in descendants
    protected abstract void initComponents();

    @Override
    public String toString() {
        return getTitle();
    }
}
