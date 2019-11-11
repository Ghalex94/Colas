namespace Video
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.mediaPLayer = new AxWMPLib.AxWindowsMediaPlayer();
            this.label1 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.mediaPLayer)).BeginInit();
            this.SuspendLayout();
            // 
            // mediaPLayer
            // 
            this.mediaPLayer.Dock = System.Windows.Forms.DockStyle.Top;
            this.mediaPLayer.Enabled = true;
            this.mediaPLayer.Location = new System.Drawing.Point(0, 0);
            this.mediaPLayer.Margin = new System.Windows.Forms.Padding(2);
            this.mediaPLayer.Name = "mediaPLayer";
            this.mediaPLayer.OcxState = ((System.Windows.Forms.AxHost.State)(resources.GetObject("mediaPLayer.OcxState")));
            this.mediaPLayer.Size = new System.Drawing.Size(600, 152);
            this.mediaPLayer.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.SystemColors.Control;
            this.label1.Location = new System.Drawing.Point(34, 319);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(554, 48);
            this.label1.TabIndex = 1;
            this.label1.Text = "GERENCIA REGIONAL DE TRANPORTES Y COMUNICACIONES LES DA LA BIENVENIDA";
            this.label1.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.HotTrack;
            this.ClientSize = new System.Drawing.Size(600, 366);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.mediaPLayer);
            this.Margin = new System.Windows.Forms.Padding(2);
            this.Name = "Form1";
            this.Text = "Form1";
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.mediaPLayer)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private AxWMPLib.AxWindowsMediaPlayer mediaPLayer;
        private System.Windows.Forms.Label label1;
    }
}

