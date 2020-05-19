deuxJoueur.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                deuxJoueur.setIcon(new ImageIcon("ressources/ButtonImage/jVSjClik.png"));
            }
            public void mouseExited(MouseEvent e){
                deuxJoueur.setIcon(new ImageIcon("ressources/ButtonImage/jVSjSR(1).png"));
            }
            public void mouseClicked(MouseEvent e){
                GameSetJ gameSetJ = GameSetJ.getInstance();
                gameSetJ.init(frame.getWidth(), frame.getHeight());
                frame.dispose();
            }
        });

        // Click bouton 'joueur vs IA'
        unJoueur.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                unJoueur.setIcon(new ImageIcon("ressources/ButtonImage/jVSiaClik.png"));
            }
            public void mouseExited(MouseEvent e){
                unJoueur.setIcon(new ImageIcon("ressources/ButtonImage/jVSiaSR.png"));
            }
            public void mouseClicked(MouseEvent e){
                GameSetIA gameSetIA = GameSetIA.getInstance();
                gameSetIA.init(frame.getWidth(), frame.getHeight());
                frame.dispose();
            }
        });
