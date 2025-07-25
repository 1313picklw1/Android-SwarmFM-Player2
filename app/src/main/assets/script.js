let player;
let muted = false;

window.onYouTubeIframeAPIReady = () => {
  player = new YT.Player('player', {
    width: '100%',
    height: '100%',
    videoId: 'BNtfy6iTafU', // Example SwarmFM stream
    playerVars: {
      autoplay: 1,
      controls: 0,
      disablekb: 1,
      modestbranding: 1,
      loop: 1,
      playlist: 'BNtfy6iTafU',
    },
    events: {
      onReady: (event) => {
        event.target.playVideo();
        event.target.setVolume(100);
      }
    }
  });
};

document.getElementById('titlebar-mute').addEventListener('click', () => {
  if (!player) return;

  muted = !muted;
  player.setVolume(muted ? 0 : 100);

  document.getElementById('titlebar-mute').classList.toggle('on', muted);
});

// Load YouTube API
const tag = document.createElement('script');
tag.src = 'https://www.youtube.com/iframe_api';
document.head.appendChild(tag);
