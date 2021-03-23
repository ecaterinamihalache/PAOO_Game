package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.UI.ClickListener;
import PaooGame.UI.UIImageButton;
import PaooGame.UI.UIManager;

import java.awt.*;

/*! \class public class MenuState extends State
    \brief Implementeaza notiunea de menu pentru joc.
 */
public class MenuState extends State{
    private UIManager uiManager;
    /*! \fn public MenuState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public MenuState(RefLinks refLinks)
    {
            ///Apel al constructorului clasei de baza.
        super(refLinks);
        uiManager=new UIManager(refLinks);
        refLinks.GetMouseManager().SetUiManager(uiManager);

        uiManager.AddObject(new UIImageButton(200,200,128,98, Assets.buton_start,new ClickListener(){
            @Override
            public void OnClick() {
                refLinks.GetMouseManager().SetUiManager(null);
                State.SetState(refLinks.GetGame().playState);
            }
        }));
    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniului.
     */
    @Override
    public void Update()
    {
        uiManager.Update();
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        uiManager.Draw(g);
    }
}
