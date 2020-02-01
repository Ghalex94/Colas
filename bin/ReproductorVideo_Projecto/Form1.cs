using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Text;
using System.Windows.Forms;

namespace Video
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            timer1.Enabled = true;
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            this.lblTitulo.SetBounds(0, (this.Height/4)*3 - (int)(this.Height * 0.03), (this.Width/4)*3, 50);

            this.lblHora.SetBounds((this.Width/4)*3, (this.Height/4)*3 - (int)(this.Height * 0.03), this.Width/4, 50);

            this.mediaPLayer.Height = ((this.Height / 4) * 3);

            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;

            string directory = AppDomain.CurrentDomain.BaseDirectory;

            foreach (var item in Directory.GetFiles(directory, "videos\\*.mp4"))
            {
                WMPLib.IWMPMedia nueva = mediaPLayer.newMedia(item);
                mediaPLayer.currentPlaylist.appendItem(nueva);
            }
            mediaPLayer.Ctlcontrols.play();
            mediaPLayer.uiMode = "none";
            mediaPLayer.settings.setMode("loop", true);
            mediaPLayer.settings.volume = 40;

            //mediaPLayer.Dock = DockStyle.Fill;
            mediaPLayer.stretchToFit = true;

        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            lblHora.Text = "Son la's:  " + DateTime.Now.ToString("hh:mm:ss tt");
        }
    }
}
